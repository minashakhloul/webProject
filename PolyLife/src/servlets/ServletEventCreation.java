package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import connectionDB.ConnexionDB;

/**
 * Servlet implementation class ServletEventCreation
 */
public class ServletEventCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
	public static final String creationEventPage = "/protected/eventCreation.jsp";
	public static final String creationSuccesPage = "/protected/eventCreation.jsp";
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( creationEventPage ).forward( request, response );
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		con = new ConnexionDB();
		eventCreation(request);
    	
        this.getServletContext().getRequestDispatcher( creationSuccesPage ).forward( request, response );
	}


	public void eventCreation(HttpServletRequest request) {
		String title = request.getParameter( "title" );
		
		String day = request.getParameter( "day" );
		String month = request.getParameter( "month" );
		String year = request.getParameter( "year" );
		String hour = request.getParameter( "hour" );
		String minutes = request.getParameter( "minutes" );
		String description = request.getParameter( "description" );
	}

}
