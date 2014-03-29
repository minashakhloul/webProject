package beans;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class ConnexionClient {

	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PASS = "password";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public static String getChampEmail() {
		return CHAMP_EMAIL;
	}

	public static String getChampPass() {
		return CHAMP_PASS;
	}

	public Client connecterUtilisateur(HttpServletRequest request) {
		/* Récupération des champs du formulaire */
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		Client utilisateur = new Client();
		/* Validation du champ email. */
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		utilisateur.setlogin(email);
		/* Validation du champ mot de passe. */
		try {
			validationMotDePasse(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		utilisateur.setMotDePasse(motDePasse);
		/* Initialisation du résultat global de la validation. */
		if (erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}
		return utilisateur;
	}

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationEmail(String email) throws Exception {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Please insert a valid email.");
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.length() < 3) {
				throw new Exception("The password must contain at least 3 characters.");
			}
		} else {
			throw new Exception("Please insert your password");
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
}
