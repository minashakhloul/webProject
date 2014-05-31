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

import beans.Client;
import beans.Event;
import connectionDB.ConnexionDB;

public class ListeEvenements extends HttpServlet {

	private ConnexionDB con = null;
	private Client utilisateur;
	private HashMap<Integer, Event> myEvents;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delete = request.getParameter("delete");
		HttpSession session = request.getSession();
		HashMap<Integer, Event> listEvent = (HashMap<Integer, Event>) session.getAttribute("EventsUser");
		utilisateur = (Client) session.getAttribute("user");
		con = new ConnexionDB();
		if (delete == null)
			getEvenements(utilisateur.getId());
		else {
			int idEvent = Integer.parseInt(request.getParameter("idEvenement"));
			deleteEvent(idEvent, listEvent);
			myEvents = listEvent;
		}
		session.setAttribute("EventsUser", myEvents);
		this.getServletContext().getRequestDispatcher("/protected/listEvenement.jsp").forward(request, response);
	}

	private void deleteEvent(int idEvent, HashMap<Integer, Event> listEvent) {
		con.insertData("DELETE FROM evenement WHERE idEvenement =" + idEvent);
		listEvent.remove(idEvent);
	}

	public boolean getEvenements(int identifiant) {
		myEvents = new HashMap<Integer, Event>();
		ResultSet rs = null;
		try {
			rs = con.selectData("SELECT * FROM evenement WHERE idEtudiant=" + identifiant);
			while (rs.next()) {
				Event eve = new Event();
				eve.setIdEvent(rs.getInt("idEvenement"));
				eve.setIdStudent(rs.getInt("idEtudiant"));
				eve.setTitle(rs.getString("titre"));
				eve.setDate(rs.getString("date"));
				eve.setTime(rs.getString("heure"));
				eve.setDescription(rs.getString("description"));
				myEvents.put(eve.getIdEvent(), eve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}