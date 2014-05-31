package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Annoncement;
import beans.Client;

import com.oreilly.servlet.MultipartRequest;

import connectionDB.ConnexionDB;

public class ServletAnnoncementCreation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
	private String filePath;
	private final String creationAnnoncementPage = "/protected/annoncementCreation.jsp";
	private final String creationSuccessPage = "/protected/annoncementSucces.jsp";
	private final String registrationLink = "/PolyLife/inscription";

	public void init() {
		filePath = getServletContext().getInitParameter("file-upload") + "annoncements/";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null)
			response.sendRedirect(registrationLink);
		else
			this.getServletContext().getRequestDispatcher(creationAnnoncementPage).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		con = new ConnexionDB();
		eventCreation(request);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.getServletContext().getRequestDispatcher(creationSuccessPage).forward(request, response);
	}

	private void eventCreation(HttpServletRequest request) {
		Annoncement annoncement = new Annoncement();
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("user");
		int idUser = client.getId();
		annoncement.setIdStudent(idUser);
		try {
			MultipartRequest mRequest = new MultipartRequest(request, filePath);
			String title = mRequest.getParameter("title");
			annoncement.setTitle(title);
			int price = Integer.parseInt(mRequest.getParameter("price"));
			annoncement.setPrice(price);
			String description = mRequest.getParameter("description");
			annoncement.setDescription(description);
			String req = "INSERT INTO annonce (idEtudiant,titre,description,prix) " + "VALUES ('" + idUser + "','" + title + "','" + description
					+ "','" + price + "')";
			con.insertData(req);
			if (mRequest.getFile("imgAnnoncement") != null) {
				String loadedFilePath = mRequest.getFile("imgAnnoncement").getAbsolutePath();
				String[] repos = loadedFilePath.split(Pattern.quote(File.separator));
				annoncement.setEventFilePath(repos[repos.length - 1]);
				loadedFilePath = "";
				for (String s : repos) {
					loadedFilePath = loadedFilePath + s + "/";
				}
				loadedFilePath = loadedFilePath.substring(0, loadedFilePath.length() - 2);
				int idAnnoncement = getIdRecentAnnoncement(idUser);
				if (idAnnoncement != -1) {
					annoncement.setIdAnnoncement(idAnnoncement);
					req = "INSERT INTO annoncephoto (idAnnonce, urlPhoto) " + "VALUES ('" + idAnnoncement + "','/" + loadedFilePath + "/')";
					con.insertData(req);
				}
			}
			session.setAttribute("annoncement", annoncement);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getIdRecentAnnoncement(int idStudent) {
		int idAnnoncement = -1;
		String req = "SELECT idAnnonce FROM annonce WHERE idEtudiant = \"" + idStudent + "\"";
		ResultSet rs = con.selectData(req);
		int maxIdAnnoncement = idAnnoncement;
		try {
			while (rs.next()) {
				idAnnoncement = Integer.parseInt(rs.getString("idAnnonce"));
				if (maxIdAnnoncement < idAnnoncement)
					maxIdAnnoncement = idAnnoncement;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxIdAnnoncement;
	}
}
