package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Annoncement;
import beans.Client;
import connectionDB.ConnexionDB;

public class ListeAnnonces extends HttpServlet {

	private ConnexionDB con = null;
	private Client utilisateur;
	private HashMap<Integer, Annoncement> myAnnoncements;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delete = request.getParameter("delete");
		HttpSession session = request.getSession();
		HashMap<Integer, Annoncement> listAnnonce = (HashMap<Integer, Annoncement>) session.getAttribute("AnnoncesUser");
		utilisateur = (Client) session.getAttribute("user");
		CreateConnection();
		if (delete == null)
			getAnnonces(utilisateur.getId());
		else {
			int idAnnonce = Integer.parseInt(request.getParameter("idAnnonce"));
			deleteAnnonce(idAnnonce, listAnnonce);
			myAnnoncements = listAnnonce;
		}
		session.setAttribute("AnnoncesUser", myAnnoncements);
		this.getServletContext().getRequestDispatcher("/protected/listAnnonce.jsp").forward(request, response);
	}

	private void deleteAnnonce(int idAnnonce, HashMap<Integer, Annoncement> listAnnonce) {
		con.insertData("DELETE FROM annonce WHERE idAnnonce =" + idAnnonce);
		listAnnonce.remove(idAnnonce);
	}

	/**
	 * Creation d'une connexion avec la bdd
	 */
	public void CreateConnection() {
		con = new ConnexionDB();
	}

	public boolean getAnnonces(int identifiant) {
		myAnnoncements = new HashMap<Integer, Annoncement>();
		ResultSet rs = null;
		try {
			rs = con.selectData("SELECT * FROM annonce WHERE idEtudiant=" + identifiant);
			while (rs.next()) {
				Annoncement ann = new Annoncement();
				ann.setDescription(rs.getString("description"));
				ann.setIdAnnoncement(rs.getInt("idAnnonce"));
				ann.setIdStudent(rs.getInt("idEtudiant"));
				ann.setPrice(rs.getInt("prix"));
				ann.setTitle(rs.getString("titre"));
				myAnnoncements.put(ann.getIdAnnoncement(), ann);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			return false;
		}
		return true;
	}
}