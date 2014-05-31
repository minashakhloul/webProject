package servlets.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
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
		
		if(request.getParameter("emailID") != null && !request.getParameter("emailID").isEmpty())
		{
			setEmailSeen(request);
		}
		else
		{
			displayEmails(request, response);
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		createEmail(request, response);
	}
	
	public void setEmailSeen(HttpServletRequest request)
	{
		connection = new ConnexionDB();
		
		HttpSession session = request.getSession();
		Client user = (Client) session.getAttribute("user");
		
		String req = "UPDATE messagerie SET seen = 1 WHERE idMessage = " + request.getParameter("emailID");
		System.out.println(req);
		connection.insertData(req);
	}
	
	public void displayEmails(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		connection = new ConnexionDB();
		ArrayList<Email> emailList = new ArrayList<Email>();
		HttpSession session = request.getSession();
		Client user = (Client) session.getAttribute("user");
		
		ResultSet rs = connection.selectData("SELECT idMessage, subject, content, expediteur, seen FROM messagerie WHERE destinataire = '" + user.getLogin() + "' ORDER BY idMessage DESC");
		try {
			while(rs.next())
			{
				emailList.add(new Email(rs.getInt("idMessage"), rs.getString("subject"), rs.getString("content"), rs.getString("expediteur"), rs.getBoolean("seen")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title> Inbox </title>");
		out.println("<link type='text/css' rel='stylesheet' href='/PolyLife/inc/styleAcceuil.css' />");
		out.println("<link href=\"/PolyLife/inc/style.css\" rel=\"stylesheet\" type=\"text/css\">");
		out.println("<script type=\"text/javascript\" src=\"../inc/js/email.js\"> </script>");

		out.println("<link type='text/css' rel='stylesheet' href='/PolyLife/inc/bootstrap.css' />");
		out.println("<link type='text/css' rel='stylesheet' href='/PolyLife/inc/bootstrap1.css' />");

		out.println("<script " + 
			"src='//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js'></script>"+
		" <script "+
			" src='//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>" +
		"</head>");
		

		out.println("</head>");
		out.println("<body>");
		
		out.println("<div class='navbar navbar-inverse'>" +
		"<div class='navbar-header'>" +
			"<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-inverse-collapse'></button>" +
			"<a class='navbar-brand' href='/PolyLife/protected/acceuil.jsp'>PolyLife</a>" +
		"</div>" +
		"<div class='navbar-collapse collapse navbar-inverse-collapse'>" +
			"<ul class='nav navbar-nav'>" +
				"<li><a href='/PolyLife/protected/acceuil.jsp'>Accueil</a></li>" +
			"</ul>" +
			"<form class='navbar-form navbar-left'>" +
				"<input type='text' class='form-control col-lg-8' placeholder='Search'>" +
			"</form>" +
			"<ul class='nav navbar-nav navbar-right'>" +
				"<li><a href='/PolyLife/protected/profil/profil.jsp?mail=" + user.getLogin() + "'>" + user.getFirstName() + " " + user.getLastName() + "</a></li>" +
				"<li><a href='/PolyLife/protected/email/newEmail'> <c:out value='Email'/>" +
				"</a></li>" +
				"<li><a href='/PolyLife/ServletLogin?signOut=signOut'>Sign" +
						"out</a></li>" +
			"</ul>" +
		"</div>" +
	"</div>" +
	"<div id='sidebar-left'>" +
		"<p align='center' style='font-size:20px'>Online Users</p>" +
		"<div class='inside-sidebar'>" +
			"<table class='table table-striped table-hover ' id='onlineUsers'>" +
			"</table>" +
		"</div>" +
	"</div>" +
	"<div id='sidebar-right'>" +
		"<ul class='nav nav-pills nav-stacked' style='max-width: 300px;'>" +
			"<li class='dropdown'><a class='dropdown-toggle' data-toggle='dropdown' href='#'>Annonces<span class='caret'></span></a>" +
				"<ul class='dropdown-menu'>" +
					"<li><a href='/PolyLife/ListeAnnonces'>Mes annonces</a></li>" +
					"<li><a href='/PolyLife/protected/annoncementCreation.jsp'>Créer annonce</a></li>" +
				"</ul></li>" +
			"<li class='dropdown'><a class='dropdown-toggle' data-toggle='dropdown' href='#'>Evènements<span class='caret'></span>" +
			"</a>" +
				"<ul class='dropdown-menu'>" +
					"<li><a href='/PolyLife/ListeEvenements'>Mes évènements</a></li>" +
					"<li><a href='/PolyLife/protected/eventCreation.jsp'>Créer un évènement</a></li>" +
				"</ul></li>" +
				"<li class='dropdown'><a class='dropdown-toggle' data-toggle='dropdown' href='#'>Offres d'emploi<span class='caret'></span>" +
			"</a>" +
				"<ul class='dropdown-menu'>" +
					"<li><a href='/PolyLife/ListeOffresEmploi'>Mes offres d'emploi</a></li>" +
					"<li><a href='/PolyLife/protected/jobOfferCreation.jsp'>Créer un offre d'emploi</a></li>" +
				"</ul></li>" +
		"</ul>" +
	"</div>");
		
		out.println("<div id='headerMail'>");
		out.println("<a href=\"/PolyLife/email/displayMail\">Refresh</a>");
		out.println("<a href=\"../protected/email/newEmail.jsp\">New</a>");
		
		String successMessage = (String)request.getAttribute("successMessage");
		if(successMessage != null &&!successMessage.isEmpty())
		{
			out.println("<span id='successMessage'>" + successMessage + "</span>");
		}
		
		out.println("</div>");
		out.println("<div id='mailList'>");
		out.println("<table border='2px'><tr><th>From</th><th>Subject</th>");
		
		for (Email email : emailList) {
			if(email.isSeen()) 
				out.println("<tr id='mail"+ email.getID() +"' onClick='displayMailContent(\""+ email.getSubject() +"\" , \""+ email.getContent() +"\" , \""+ email.getFrom() +"\", \""+ email.getID() +"\")'><td class='fromMail'>" + email.getFrom() + "</td><td class='subjectMail'>" + email.getSubject() + "</td></tr>");	
			else
				out.println("<tr style='font-weight: bold;' id='mail"+ email.getID() +"' onClick='displayMailContent(\""+ email.getSubject() +"\" , \""+ email.getContent() +"\" , \""+ email.getFrom() +"\", \""+ email.getID() +"\")'><td class='fromMail'>" + email.getFrom() + "</td><td class='subjectMail'>" + email.getSubject() + "</td></tr>");	
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<div id='mailContent'>");
		out.println("<div id='email'></div>");
		out.println("<div id='subject'></div>");
		out.println("<div id='content'></div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
	public void createEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		String content = request.getParameter("content");
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String from = ((Client) session.getAttribute("user")).getLogin();
		
		connection = new ConnexionDB();
		
		String req = "INSERT INTO messagerie (subject,content,destinataire,expediteur,seen) VALUES('" + subject + "','" + content + "','" + to + "','" + from + "','0')";
		System.out.println(req);
		if(!to.isEmpty() && connection.insertData(req))
		{
			request.setAttribute("successMessage", "You're mail has been sent");
			doGet(request, response);
		}
		else
		{
			request.setAttribute("errorMessage", "Error during sending mail. Please retry later.");
			getServletContext().getRequestDispatcher("/protected/email/newEmail.jsp").forward(request, response);
		}
	}
	
	public static ArrayList<String> getEmailAddressesList()
	{
		ArrayList<String> list = new ArrayList<String>();
		ConnexionDB connection = new ConnexionDB();
		
		
		String req = "SELECT email from etudiant";
		ResultSet rs = connection.selectData(req);
		try {
			while(rs.next())
			{
				list.add(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req = "SELECT email from professeur";
		rs = connection.selectData(req);
			try {
				while(rs.next())
				{
					list.add(rs.getString("email"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
	
}
