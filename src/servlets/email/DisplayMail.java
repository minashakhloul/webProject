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
		System.out.println("doget");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connection = new ConnexionDB();
		ArrayList<Email> emailList = new ArrayList<Email>();
		HttpSession session = request.getSession();
		Client user = (Client) session.getAttribute("user");
		
		ResultSet rs = connection.selectData("SELECT subject, content, expediteur, seen FROM messagerie WHERE destinataire = '" + user.getLogin() + "'");
		try {
			while(rs.next())
			{
				emailList.add(new Email(rs.getString("subject"), rs.getString("content"), rs.getString("expediteur"), rs.getBoolean("seen")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE> Inbox </TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<div>");
		out.println("<table border='2px'><tr><th>From</th><th>Subject</th>");
		
		for (Email email : emailList) {
			
			out.println("<tr onClick='displayContent("+ email.getID() +")'><td>" + email.getFrom() + "</td><td>" + email.getSubject() + "</td></tr>");	
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}	
	
}
