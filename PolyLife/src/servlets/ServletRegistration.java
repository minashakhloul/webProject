package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.Speciality;
import beans.StudentStatus;
import beans.UserType;
import connectionDB.ConnexionDB;


public class ServletRegistration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
	private Connection conn;
	private Statement st;
	private ResultSet rs;
    public static final String registrationpage = "/protected/registration.jsp";


	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        this.getServletContext().getRequestDispatcher( registrationpage ).forward( request, response );
	    }
	    
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	    	CreateConnection();
	    	studentCreation(request);
	    	//Client
	    	//HttpSession session = request.getSession();
	    	//session.setAttribute("user", Client);
	        this.getServletContext().getRequestDispatcher( registrationpage ).forward( request, response );
	    }
	    
	    public void CreateConnection() {
			try {
				con = new ConnexionDB();
				Connection conn = con.connect;
				st = conn.createStatement();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	    
	    public boolean userCreation(HttpServletRequest request) {
			String userType = request.getParameter( "userType" );
			switch(userType) {
				case "student": 	return studentCreation(request);
				case "exStudent":	return exStudentCreation(request);
				case "professor":	return professorCreation(request);
			}
			return false;
	    }
	    
	    public boolean studentCreation(HttpServletRequest request) {
	    	String name = request.getParameter( "name" );
	    	String firstName = request.getParameter( "firstName" );
	    	String emailAdress = request.getParameter( "emailAdress" );
	    	
	    	String year = request.getParameter( "year" );
	    	String month = request.getParameter( "month" ); 
	    	String day = request.getParameter( "day" );
	    	String nationality = request.getParameter( "nationality" );
	    	String sex = request.getParameter( "sex" );
	    	
	    	String phoneNumber = request.getParameter( "phoneNumber" );
	    	int phoneNumberInteger; 
	    	String statusStudent = request.getParameter( "statusStudent" );
	    	int idStatusStudent = StudentStatus.getValueOf( StudentStatus.getStatusOf(statusStudent) );
	    	
	    	String speciality = request.getParameter( "speciality" );
	    	int idSpeciality = Speciality.getValueOf(Speciality.getStatusOf(speciality));
	    	
	    	String company = request.getParameter( "company" );
	    	
	    	String promotion = request.getParameter( "promotion" );
	    	String currentYear = request.getParameter( "currentYear" );
	    	String passWord = request.getParameter( "passWord" );
	    	
	    	boolean success = false;
	    	ResultSet rs = null;
	    	
	    	try {
	    		try {
	    			phoneNumberInteger = Integer.parseInt(phoneNumber);
	    		}
	    		catch (NumberFormatException e) {
	    			phoneNumberInteger = -1;
	    		}
	    		System.out.println(phoneNumber == null);
	    		String req = "INSERT INTO etudiant (nom,prenom,email,dateDeNaissance,nationalite,sex,telephone,"
	    				+ "idStatusEtudiant," + "idSpecialite,promotion,annee) VALUES ('" + name + "','" 
	    				+ firstName + "','" + emailAdress + "'," 
	    				+ "STR_TO_DATE('"+ day + "." + month + "." + year + "','%d.%m.%Y')" + ",'" 
	    				+ nationality + "','" + sex + "','" + phoneNumberInteger + "','" + idStatusStudent 
	    				+ "','" + idSpeciality + "','" + Integer.parseInt(promotion) + "','" 
	    				+ Integer.parseInt(currentYear) + "')";
	    		
	    		System.out.println(req);
	    		st.execute(req);
	    		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return true;
	    }
	    public boolean exStudentCreation(HttpServletRequest request) {
	    	return false;
	    }
	    public boolean professorCreation(HttpServletRequest request) {
	    	return false;
	    }
	    
	    
}