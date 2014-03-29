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

import beans.ConnexionClient;
import connectionDB.ConnexionDB;

public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
	private Statement st;
	private ResultSet rs;
	private Connection conn;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signOut = request.getParameter("signOut");
		String identifiant = request.getParameter("email");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		ConnexionClient form = (ConnexionClient) request.getAttribute("form");
		System.out.println(form.getResultat());
		CreateConnection();
		HttpSession session = request.getSession();
		if (signOut != null) {
			session.invalidate();
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		if (userType.equals("student") || userType.equals("exStudent")) {
			if (authentificationStudent(identifiant, password)) {
				System.out.println("Authentification succeeded");
				session.setAttribute("user", identifiant);
				System.out.println("Redirection to home...");
				response.sendRedirect(request.getContextPath() + "/protected/home.jsp");
			} else {
				form.getErreurs().put("authentificationError", "Invalid email or password...");
				session.setAttribute("form", form);
				this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
			}
		} else if (userType.equals("professor")) {
			if (authentificationProf(identifiant, password)) {
				System.out.println("Authentification succeeded");
				session.setAttribute("user", identifiant);
				System.out.println("Redirection to home...");
				response.sendRedirect(request.getContextPath() + "/protected/home.jsp");
			} else {
				form.getErreurs().put("authentificationError", "Invalid email or password...");
				session.setAttribute("form", form);
				this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
			}
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
	public boolean authentificationStudent(String identifiant, String mdp) {
		String email = null;
		String motDePasse = null;
		boolean success = false;
		try {
			rs = st.executeQuery("SELECT email,password FROM etudiant");
			while (rs.next()) {
				email = rs.getString("email");
				motDePasse = rs.getString("password");
				success = (email.equals(identifiant) && motDePasse.equals(mdp));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return success;
	}

	public boolean authentificationProf(String identifiant, String mdp) {
		String email = null;
		String motDePasse = null;
		boolean success = false;
		try {
			rs = st.executeQuery("SELECT email, password FROM professeur");
			while (rs.next()) {
				email = rs.getString("email");
				motDePasse = rs.getString("password");
				success = (email.equals(identifiant) && motDePasse.equals(mdp));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return success;
	}
}
