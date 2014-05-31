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

import beans.Client;
import beans.Event;

import com.oreilly.servlet.MultipartRequest;

import connectionDB.ConnexionDB;

/**
 * Servlet implementation class ServletEventCreation
 */
public class ServletEventCreation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
	private String filePath;
	private final String creationEventPage = "/protected/eventCreation.jsp";
	private final String creationSuccessPage = "/protected/eventSuccess.jsp";
	private final String registrationLink = "/PolyLife/inscription";

	public void init() {
		filePath = getServletContext().getInitParameter("file-upload") + "events/";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null)
			response.sendRedirect(registrationLink);
		else
			this.getServletContext().getRequestDispatcher(creationEventPage).forward(request, response);
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
		Event event = new Event();
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("user");
		int idUser = client.getId();
		event.setIdStudent(idUser);
		try {
			MultipartRequest mRequest = new MultipartRequest(request, filePath);
			String title = mRequest.getParameter("title");
			event.setTitle(title);
			String day = mRequest.getParameter("day");
			String month = mRequest.getParameter("month");
			String year = mRequest.getParameter("year");
			event.setDate(day + " " + whichMonth(Integer.parseInt(month)) + " " + year);
			String hour = mRequest.getParameter("hour");
			String minutes = mRequest.getParameter("minutes");
			event.setTime(hour + ":" + minutes);
			String description = mRequest.getParameter("description");
			event.setDescription(description);
			String req = "INSERT INTO evenement (idEtudiant,titre,date,heure,description) " + "VALUES ('" + idUser + "','" + title + "',"
					+ "STR_TO_DATE('" + day + "." + month + "." + year + "','%d.%m.%Y')" + ",'" + hour + ":" + minutes + "','" + description + "')";
			con.insertData(req);
			if (mRequest.getFile("imgEvent") != null) {
				String loadedFilePath = mRequest.getFile("imgEvent").getAbsolutePath();
				String[] repos = loadedFilePath.split(Pattern.quote(File.separator));
				event.setEventFilePath(repos[repos.length - 1]);
				loadedFilePath = "";
				for (String s : repos) {
					loadedFilePath = loadedFilePath + s + "/";
				}
				loadedFilePath = loadedFilePath.substring(0, loadedFilePath.length() - 2);
				int idEvent = getIdRecentEvent(idUser);
				if (idEvent != -1) {
					event.setIdEvent(idEvent);
					req = "INSERT INTO evenementphoto (idEvenement, urlPhoto) VALUES ('" + idEvent + "','/" + loadedFilePath + "/')";
					// System.out.println(req);
					con.insertData(req);
				}
			}
			session.setAttribute("event", event);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getIdRecentEvent(int idStudent) {
		int idEvent = -1;
		String req = "SELECT idEvenement FROM evenement WHERE idEtudiant = \"" + idStudent + "\"";
		ResultSet rs = con.selectData(req);
		int maxIdEvent = idEvent;
		try {
			while (rs.next()) {
				idEvent = Integer.parseInt(rs.getString("idEvenement"));
				if (maxIdEvent < idEvent)
					maxIdEvent = idEvent;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxIdEvent;
	}

	private String whichMonth(int idMonth) {
		if (idMonth < 0 || idMonth > 12)
			return "";
		String[] months = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" };
		return months[idMonth];
	}
}
