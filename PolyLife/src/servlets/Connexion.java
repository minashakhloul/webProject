package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.ConnexionClient;

public class Connexion extends HttpServlet {

	private static final long serialVersionUID = 6157956581918801154L;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "user";
	public static final String VUE = "/login.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		// this.getServletContext().getRequestDispatcher(VUE).forward(request,
		// response);
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
		ConnexionClient form = new ConnexionClient();
		/* Traitement de la requête et récupération du bean en résultant */
		Client utilisateur = form.connecterUtilisateur(request);
		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		/**
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Utilisateur à la session, sinon suppression du bean de la session.
		 */
		if (form.getErreurs().isEmpty()) {
			/* Stockage du formulaire et du bean dans l'objet request */
			session.setAttribute(ATT_SESSION_USER, utilisateur);
			request.setAttribute(ATT_FORM, form);
			this.getServletContext().getRequestDispatcher("/ServletLogin").forward(request, response);
		} else {
			session.setAttribute(ATT_SESSION_USER, utilisateur);
			request.setAttribute(ATT_FORM, form);
			this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
		}
	}
}