package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.ConnexionClient;
import beans.UserType;
import connectionDB.ConnexionDB;

public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
	private Client utilisateur;
	private ArrayList<Client> onlineUsers;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signOut = request.getParameter("signOut");
		String registration = request.getParameter("registration");
		HttpSession session = request.getSession();
		utilisateur = (Client) session.getAttribute("user");
		ConnexionClient form = (ConnexionClient) request.getAttribute("form");
		String email = utilisateur.getLogin();
		String password = utilisateur.getMotDePasse();
		String userType = utilisateur.getUserType();
		CreateConnection();
		if (signOut != null) {
			disconnect();
			session.invalidate();
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (authentification(email, password, userType) && registration == null) {
			storeOnlineUserIntoDB();
			getOnlineUsers();
			session.setAttribute("onlineUsers", onlineUsers);
			session.setAttribute("user", utilisateur);
			this.getServletContext().getRequestDispatcher("/protected/acceuil.jsp").forward(request, response);
		} else if (registration == null) {
			form.getErreurs().put("authentification", "Unknown email or password. Please try again");
			session.setAttribute("form", form);
			session.setAttribute("user", utilisateur);
			this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
		} else if (registration != null) {
			this.getServletContext().getRequestDispatcher("/protected/registration.jsp").forward(request, response);
		}
	}

	/**
	 * Creation d'une connexion avec la bdd
	 */
	public void CreateConnection() {
		con = new ConnexionDB();
	}

	/**
	 * @param identifiant
	 * @param mdp
	 * @return vrai si l'authentification est correct
	 */
	public boolean authentification(String identifiant, String mdp, String typeUser) {
		String ident = null;
		String motDePasse = null;
		boolean success = false;
		ResultSet rs = null;
		try {
			switch (UserType.getTypeOf(typeUser)) {
			case STUDENT:
				rs = con.selectData("SELECT idEtudiant, email, password, nom, prenom FROM etudiant ");
				break;
			case EX_STUDENT:
				rs = con.selectData("SELECT idEtudiant, email, password FROM etudiant ");
				break;
			case PROFESSOR:
				rs = con.selectData("SELECT idProfessor, email, password FROM professeur ");
				break;
			}
			while (rs.next()) {
				ident = rs.getString("email");
				motDePasse = rs.getString("password");
				success = (ident.equals(identifiant) && motDePasse.equals(mdp));
				if (success) {
					utilisateur.setFirstName(rs.getString("prenom"));
					utilisateur.setLastName(rs.getString("nom"));
					if (UserType.getTypeOf(typeUser).equals(UserType.PROFESSOR))
						utilisateur.setId(rs.getInt("idProfessor"));
					else
						utilisateur.setId(rs.getInt("idEtudiant"));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return success;
	}

	private boolean alreadyInserted() {
		try {
			ResultSet rs = null;
			rs = con.selectData("SELECT * FROM onlineUsers WHERE idEtudiant = " + utilisateur.getId());
			return rs.isBeforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	private void storeOnlineUserIntoDB() {
		if (!alreadyInserted())
			con.insertData("INSERT INTO onlineUsers (idEtudiant) values('" + utilisateur.getId() + "')");
	}

	private void disconnect() {
		con.insertData("DELETE FROM onlineUsers WHERE idEtudiant = " + utilisateur.getId());
		onlineUsers.clear();
	}

	private void getOnlineUsers() {
		onlineUsers = new ArrayList<Client>();
		ResultSet rs = null;
		try {
			rs = con.selectData("SELECT * FROM etudiant WHERE idEtudiant IN ( SELECT idEtudiant FROM onlineUsers WHERE idEtudiant NOT IN("
					+ utilisateur.getId() + "))");
			while (rs.next()) {
				onlineUsers.add(new Client(rs.getString("password"), rs.getString("email"), null, rs.getString("prenom"), rs.getString("nom"), rs
						.getInt("idEtudiant")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
