package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	private Statement st;
	private ResultSet rs;
	private Connection conn;
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
			session.invalidate();
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (authentification(email, password, userType)) {
			session.setAttribute("utilisateur", utilisateur);
			this.getServletContext().getRequestDispatcher("/protected/acceuil.jsp").forward(request, response);
		} else {
			form.getErreurs().put("authentification", "Unknown email or password. Please try again");
			session.setAttribute("form", form);
			session.setAttribute("utilisateur", utilisateur);
			this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
		}
		Destroy();
	}

	/**
	 * Creation d'une connexion avec la bdd
	 */
	public void CreateConnection() {
		try {
			con = new ConnexionDB();
			Connection conn = con.connect;
			st = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * * Destruction de la Connection et la session une fois qu'on a termine de<br>
	 * communiquer avec la bdd
	 */
	public void Destroy() {
		try {
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
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
				rs = st.executeQuery("SELECT email,password, nom, prenom FROM etudiant ");
				break;
			case EX_STUDENT:
				rs = st.executeQuery("SELECT email,password FROM etudiant ");
				break;
			case PROFESSOR:
				rs = st.executeQuery("SELECT email,password FROM professeur ");
				break;
			}
			while (rs.next()) {
				ident = rs.getString("email");
				motDePasse = rs.getString("password");
				success = (ident.equals(identifiant) && motDePasse.equals(mdp));
				if (success) {
					utilisateur.setFirstName(rs.getString("prenom"));
					utilisateur.setLastName(rs.getString("nom"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return success;
	}
}
