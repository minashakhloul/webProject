package servlets.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.Email;
import connectionDB.ConnexionDB;

public class DisplayMail extends HttpServlet {

	ConnexionDB connection;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("emailID") != null && !request.getParameter("emailID").isEmpty()) {
			setEmailSeen(request);
		} else {
			displayEmails(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createEmail(request, response);
	}

	public void setEmailSeen(HttpServletRequest request) {
		connection = new ConnexionDB();
		HttpSession session = request.getSession();
		Client user = (Client) session.getAttribute("utilisateur");
		String req = "UPDATE messagerie SET seen = 1 WHERE idMessage = " + request.getParameter("emailID");
		System.out.println(req);
		connection.insertData(req);
	}

	public void displayEmails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		connection = new ConnexionDB();
		ArrayList<Email> emailList = new ArrayList<Email>();
		HttpSession session = request.getSession();
		Client user = (Client) session.getAttribute("utilisateur");
		ResultSet rs = connection.selectData("SELECT idMessage, subject, content, expediteur, seen FROM messagerie WHERE destinataire = '"
				+ user.getLogin() + "' ORDER BY idMessage DESC");
		try {
			while (rs.next()) {
				emailList.add(new Email(rs.getInt("idMessage"), rs.getString("subject"), rs.getString("content"), rs.getString("expediteur"), rs
						.getBoolean("seen")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title> Inbox </title>");
		out.println("<script type=\"text/javascript\" src=\"../inc/js/email.js\"> </script>");
		out.println("<link href=\"../inc/style.css\" rel=\"stylesheet\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='headerMail'>");
		out.println("<a href=\"/PolyLife/email/displayMail\">Refresh</a>");
		out.println("<a href=\"../protected/email/newEmail.jsp\">New</a>");
		out.println("<a href=\"../protected/acceuil.jsp\">Accueil</a>");
		String successMessage = (String) request.getAttribute("successMessage");
		if (successMessage != null && !successMessage.isEmpty()) {
			out.println("<span id='successMessage'>" + successMessage + "</span>");
		}
		out.println("</div>");
		out.println("<div id='mailList'>");
		out.println("<table border='2px'><tr><th>From</th><th>Subject</th>");
		for (Email email : emailList) {
			if (email.isSeen())
				out.println("<tr id='mail" + email.getID() + "' onClick='displayMailContent(\"" + email.getSubject() + "\" , \"" + email.getContent()
						+ "\" , \"" + email.getFrom() + "\", \"" + email.getID() + "\")'><td>" + email.getFrom() + "</td><td>" + email.getSubject()
						+ "</td></tr>");
			else
				out.println("<tr style='font-weight: bold;' id='mail" + email.getID() + "' onClick='displayMailContent(\"" + email.getSubject()
						+ "\" , \"" + email.getContent() + "\" , \"" + email.getFrom() + "\", \"" + email.getID() + "\")'><td>" + email.getFrom()
						+ "</td><td>" + email.getSubject() + "</td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<div id='mailContent'>");
		out.println("<span id='email'></span>");
		out.println("<span id='subject'></span>");
		out.println("<span id='content'></span>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	public void createEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String content = request.getParameter("content");
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String from = ((Client) session.getAttribute("utilisateur")).getLogin();
		connection = new ConnexionDB();
		String req = "INSERT INTO messagerie (subject,content,destinataire,expediteur,seen) VALUES('" + subject + "','" + content + "','" + to
				+ "','" + from + "','0')";
		System.out.println(req);
		if (!to.isEmpty() && connection.insertData(req)) {
			request.setAttribute("successMessage", "You're mail has been sent");
			doGet(request, response);
		} else {
			request.setAttribute("errorMessage", "Error during sending mail. Please retry later.");
			getServletContext().getRequestDispatcher("/protected/email/newEmail.jsp").forward(request, response);
		}
	}

	public static ArrayList<String> getEmailAddressesList() {
		ArrayList<String> list = new ArrayList<String>();
		ConnexionDB connection = new ConnexionDB();
		String req = "SELECT email from etudiant";
		ResultSet rs = connection.selectData(req);
		try {
			while (rs.next()) {
				list.add(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req = "SELECT email from professeur";
		rs = connection.selectData(req);
		try {
			while (rs.next()) {
				list.add(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
