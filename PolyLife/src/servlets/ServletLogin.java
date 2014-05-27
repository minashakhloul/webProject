package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signOut = request.getParameter("signOut");
		HttpSession session = request.getSession();
		utilisateur = (Client) session.getAttribute("utilisateur");
		ConnexionClient form = (ConnexionClient) request.getAttribute("form");
		String email = utilisateur.getLogin();
		String password = utilisateur.getMotDePasse();
		String userType = utilisateur.getUserType();
		CreateConnection();
		if (signOut != null) {
			disconnect(utilisateur);
			session.invalidate();
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (authentification(email, password, userType)) {
			//storeOnlineUserIntoDB(utilisateur, userType);
			session.setAttribute("user", utilisateur);
			this.getServletContext().getRequestDispatcher("/protected/acceuil.jsp").forward(request, response);
		} else {
			form.getErreurs().put("authentification", "Unknown email or password. Please try again");
			session.setAttribute("form", form);
			session.setAttribute("user", utilisateur);
			this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
		}
		Destroy();
	}

	/**
	 * Creation d'une connexion avec la bdd
	 */
	public void CreateConnection() {
		con = new ConnexionDB();
	}

	/**
	 * * Destruction de la Connection et la session une fois qu'on a termine de<br>
	 * communiquer avec la bdd
	 */
	public void Destroy() {
		try {
			con.destroy();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				rs = con.selectData("SELECT email,password, nom, prenom FROM etudiant ");
				break;
			case EX_STUDENT:
				rs = con.selectData("SELECT email,password FROM etudiant ");
				break;
			case PROFESSOR:
				rs = con.selectData("SELECT email,password FROM professeur ");
				break;
			}
			while (rs.next()) {
				ident = rs.getString("email");
				motDePasse = rs.getString("password");
				success = (ident.equals(identifiant) && motDePasse.equals(mdp));
				if (success) {
					utilisateur.setFirstName(rs.getString("prenom"));
					utilisateur.setLastName(rs.getString("nom"));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return success;
	}

	private void storeOnlineUserIntoDB(Client client, String typeUser) {
		ResultSet rs = null;
		String id = null;
		try {
			switch (UserType.getTypeOf(typeUser)) {
			case STUDENT:
				rs = con.selectData("SELECT idEtudiant FROM etudiant WHERE email = '" + client.getLogin() + "' AND password = '"
						+ client.getMotDePasse() + "'");
				break;
			case EX_STUDENT:
				rs = con.selectData("SELECT idEtudiant FROM etudiant WHERE email = '" + client.getLogin() + "' AND password = '"
						+ client.getMotDePasse() + "'");
				break;
			default:
				break;
			}
			while (rs.next()) {
				id = rs.getString("idEtudiant");
			}
			con.insertData("INSERT INTO onlineUsers (idEtudiant) values('" + id + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void disconnect(Client utilisateur2) {
		String id = null;
		ResultSet rs = null;
		try {
			rs = con.selectData("SELECT idEtudiant FROM etudiant WHERE email = '" + utilisateur2.getLogin() + "' AND password = '"
					+ utilisateur2.getMotDePasse() + "'");
			while (rs.next()) {
				id = rs.getString("idEtudiant");
			}
			con.insertData("DELETE FROM onlineUsers WHERE idEtudiant = " + id);
		} catch (Exception e) {
		}
	}
}
