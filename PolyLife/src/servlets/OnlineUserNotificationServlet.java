package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import connectionDB.ConnexionDB;

/**
 * Servlet implementation class OnlineUserNotificationServlet
 */
@WebServlet("/OnlineUserNotificationServlet")
public class OnlineUserNotificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client user = (Client) session.getAttribute("user");
		int myId = user.getId();
		ArrayList<Client> onlineUsers = (ArrayList<Client>) session.getAttribute("onlineUsers");
		addSignedInUsers(myId, onlineUsers);
		session.setAttribute("onlineUsers", onlineUsers);
		PrintWriter out = response.getWriter();
		out.println(getUsersString(onlineUsers));
	}

	private String getUsersString(ArrayList<Client> onlineUsers) {
		String str = "";
		for (Client user : onlineUsers) {
			str += user.getFirstName() + " " + user.getLastName() + "\n";
		}
		return str;
	}

	private boolean userExists(ArrayList<Client> onlineUsers, Client c) {
		boolean found = false;
		for (Client user : onlineUsers) {
			if (user.getId() == c.getId()) {
				found = true;
				break;
			}
		}
		return found;
	}

	private void addSignedInUsers(int myId, ArrayList<Client> onlineUsers) {
		ConnexionDB connection = new ConnexionDB();
		ResultSet rs = null;
		try {
			rs = connection.selectData("SELECT * FROM etudiant WHERE idEtudiant IN ( SELECT idEtudiant FROM onlineUsers WHERE idEtudiant NOT IN("
					+ myId + "))");
			while (rs.next()) {
				Client user = new Client(rs.getString("password"), rs.getString("email"), null, rs.getString("prenom"), rs.getString("nom"),
						rs.getInt("idEtudiant"));
				if (!userExists(onlineUsers, user))
					onlineUsers.add(user);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
