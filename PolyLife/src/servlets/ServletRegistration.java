package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.Speciality;
import beans.StudentStatus;
import connectionDB.ConnexionDB;


public class ServletRegistration extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
    public static final String registrationPage = "/protected/registration.jsp";
    public static final String registrationLink = "/PolyLife/inscription";
    public static final String homePage = "/protected/acceuil.jsp";
    public static final String eventPage = "/PolyLife/creerEvenement";


	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        this.getServletContext().getRequestDispatcher( registrationPage ).forward( request, response );
	    }
	    
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    	
	    	con = new ConnexionDB();
	    	if(!userCreation(request)) {
	    		response.sendRedirect( registrationLink );
	    	}
	    	else {
	    		
	    		Client client = getClient(request);
		    	HttpSession session = request.getSession();
		    	session.setAttribute("user", client);
		    	try {
					con.destroy();
				} catch (SQLException e) {			
					e.printStackTrace();
				}
		    	//response.sendRedirect( eventPage );
		    	this.getServletContext().getRequestDispatcher( homePage ).forward(request, response);
		    	try {
					con.destroy();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	//this.getServletContext().getRequestDispatcher( homePage ).forward(null, response);
	    }
	     
	    private boolean userCreation(HttpServletRequest request) {
			String userType = request.getParameter( "userType" );
			switch(userType) {
				case "student": 	return studentCreation(request);
				case "exStudent": 	return exStudentCreation(request);
				case "professor":	return professorCreation(request);
			}
			return false;
	    }
	    
	    private boolean studentCreation(HttpServletRequest request) {
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
	    	
	    	String promotion = request.getParameter( "promotion" );
	    	String currentYear = request.getParameter( "currentYear" );
	    	String passWord = request.getParameter( "passWord" );
	    	String company = request.getParameter("company");

	    	try {
	    		phoneNumberInteger = Integer.parseInt(phoneNumber);
	    	}
	    	catch (NumberFormatException e) {
	    		phoneNumberInteger = -1;
	    	}

	    	if( !studentExist(emailAdress)) {

	    		String req = "INSERT INTO etudiant (nom,prenom,email,password,dateDeNaissance,nationalite,sex,telephone,"
		    				+ "idStatusEtudiant," + "idSpecialite,promotion,annee) VALUES ('" + name + "','" 
		    				+ firstName + "','" + emailAdress + "','" + passWord + "'," 
		    				+ "STR_TO_DATE('"+ day + "." + month + "." + year + "','%d.%m.%Y')" + ",'" 
		    				+ nationality + "','" + sex + "','" + phoneNumberInteger + "','" + idStatusStudent 
		    				+ "','" + idSpeciality + "','" + Integer.parseInt(promotion) + "','" 
		    				+ Integer.parseInt(currentYear) + "')";
	    		
		    	con.insertData(req);
		    	int idStudent = getIdStudentByEmail(emailAdress);
		    	if(idStudent != -1 && !company.equals("")) {
		    		String reqCompany = "INSERT INTO entreprise (idEtudiant,nomEntreprise) VALUES ('" + idStudent + "','" + company + "')";
		    		con.insertData(reqCompany);
		    	}
		    	return true;
	    	}
	    	else
	    		return false;
	    }
    
	    private boolean exStudentCreation(HttpServletRequest request) {
	    	String name = request.getParameter( "name" );
	    	String firstName = request.getParameter( "firstName" );
	    	String company = request.getParameter("company");
	    	
	    	int idStatusStudent = StudentStatus.getValueOf( StudentStatus.getStatusOf("exStudent") );
	    	
	    	String speciality = request.getParameter( "speciality" );
	    	int idSpeciality = Speciality.getValueOf(Speciality.getStatusOf(speciality));

	    	String promotion = request.getParameter( "promotion" );
	    	String emailAdress = request.getParameter( "emailAdress" );
	    	String passWord = request.getParameter( "passWord" );
	    	String year = request.getParameter( "year" );
	    	String month = request.getParameter( "month" ); 
	    	String day = request.getParameter( "day" );
	    	
	    	String phoneNumber = request.getParameter( "phoneNumber" );
	    	int phoneNumberInteger; 

	    	String nationality = request.getParameter( "nationality" );
	    	String sex = request.getParameter( "sex" );
	    	
	    	try {
	    		phoneNumberInteger = Integer.parseInt(phoneNumber);
	    	}
	    	catch (NumberFormatException e) {
	    		phoneNumberInteger = -1;
	    	}
	    	
	    	if( !studentExist(emailAdress)) {

	    		String req = "INSERT INTO etudiant (nom,prenom,email,password,dateDeNaissance,nationalite,sex,telephone,"
		    				+ "idStatusEtudiant," + "idSpecialite,promotion,annee) VALUES ('" + name + "','" 
		    				+ firstName + "','" + emailAdress + "','" + passWord + "'," 
		    				+ "STR_TO_DATE('"+ day + "." + month + "." + year + "','%d.%m.%Y')" + ",'" 
		    				+ nationality + "','" + sex + "','" + phoneNumberInteger + "','" + idStatusStudent 
		    				+ "','" + idSpeciality + "','" + Integer.parseInt(promotion) + "','-1')";
	    			    		
		    	con.insertData(req);
		    	int idStudent = getIdStudentByEmail(emailAdress);

		    	if(idStudent != -1 && !company.equals("")) {
		    		String reqCompany = "INSERT INTO entreprise (idEtudiant,nomEntreprise) VALUES ('" + idStudent + "','" + company + "')";
		    		con.insertData(reqCompany);
		    	}
		    	return true;
	    	}
	    	else
	    		return false;
	    }
	    
	    private boolean professorCreation(HttpServletRequest request) {
	    	String name = request.getParameter( "name" );
	    	String firstName = request.getParameter( "firstName" );
	    	String emailAdress = request.getParameter( "emailAdress" );
	    	String passWord = request.getParameter( "passWord" );
	    	
	    	String phoneNumber = request.getParameter( "phoneNumber" );
	    	String phoneNumberOffice = request.getParameter( "phoneNumberOffice" );
	    	int phoneNumberInteger, phoneNumberOfficeInteger;
	    	
	    	String year = request.getParameter( "year" );
	    	String month = request.getParameter( "month" ); 
	    	String day = request.getParameter( "day" );
	    	String sex = request.getParameter( "sex" );
	    	String nationality = request.getParameter( "nationality" );
	    	
	    	String[] subjects = request.getParameterValues("subjects");
	    	String[] statusProfessor = request.getParameterValues("statusProfessor");
	    	
	    	try {
	    		phoneNumberInteger = Integer.parseInt(phoneNumber);
	    	}
	    	catch (NumberFormatException e) {
	    		phoneNumberInteger = -1;
	    	}
	    	
	    	try {
	    		phoneNumberOfficeInteger = Integer.parseInt(phoneNumberOffice);
	    	}
	    	catch (NumberFormatException e) {
	    		phoneNumberOfficeInteger = -1;
	    	}
	    	
	    	if( !professorExist(emailAdress)) {

	    		String req = "INSERT INTO professeur (nom,prenom,email,password,telephoneBureau,telephone,dateDeNaissance,nationalite,sex) "
	    					+ "VALUES ('" + name + "','" + firstName + "','" + emailAdress + "','" + passWord + "','" + phoneNumberOfficeInteger 
	    					+ "','" + phoneNumberInteger + "',STR_TO_DATE('"+ day + "." + month + "." + year + "','%d.%m.%Y')" + ",'" 
		    				+ nationality + "','" + sex + "')";
	    		
		    	con.insertData(req);
		    	int idProfessor = getIdProfessorByEmail(emailAdress);
		    	if(idProfessor != -1) {
		    		for (String sub: subjects) {
		    			String reqSubject = "INSERT INTO matiere (idProf,nomMatiere) VALUES ('" + idProfessor + "','" + sub + "')";
			    		con.insertData(reqSubject);
					}
		    		
		    		for (String status: statusProfessor) {
		    			String reqStatus = "INSERT INTO statusprofesseur (idProf,nomStatusProf) VALUES ('" + idProfessor + "','" + status + "')";
			    		con.insertData(reqStatus);
					}	
		    	}
		    	return true;
	    	}
	    	else
	    		return false;
	    }	    
	    
		private boolean professorExist(String emailAdress) {
	    	String selectEmail = "SELECT (email) FROM professeur WHERE email = \"" + emailAdress + "\"";
	    	ResultSet rs = con.selectData(selectEmail);
	    	try {
				while(rs.next()) {
					try {
						if(rs.getString("email").equals(emailAdress))
							return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// r Auto-generated catch block
				e.printStackTrace();
			}
	    	return false;
		}

		private boolean studentExist(String emailAdress) {
	    	String selectEmail = "SELECT (email) FROM etudiant WHERE email = \"" + emailAdress + "\"";
	    	ResultSet rs = con.selectData(selectEmail);
	    	try {
				while(rs.next()) {
					try {
						if(rs.getString("email").equals(emailAdress))
							return true;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// r Auto-generated catch block
				e.printStackTrace();
			}
	    	return false;
	    }
	    
		private int getIdProfessorByEmail(String emailAdress) {
			int id = -1;
	    	String req = "SELECT (idProfessor) FROM professeur WHERE email = \"" + emailAdress + "\"";
	    	ResultSet rs = con.selectData(req);
	    	try {
				rs.next();
				id = Integer.parseInt(rs.getString("idProfessor"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return id;
		}

	    private int getIdStudentByEmail(String emailAdress) {
	    	int id = -1;
	    	String req = "SELECT (idEtudiant) FROM etudiant WHERE email = \"" + emailAdress + "\"";
	    	ResultSet rs = con.selectData(req);
	    	try {
				rs.next();
				id = Integer.parseInt(rs.getString("idEtudiant"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return id;
	    }

	    private Client getClient(HttpServletRequest request) {
	    	Client client = new Client();
	    	client.setFirstName(request.getParameter( "firstName" ));
	    	client.setLastName(request.getParameter( "name" ));
	    	client.setLogin(request.getParameter( "emailAdress" ));
	    	client.setMotDePasse(request.getParameter( "passWord" ));
	    	client.setUserType(request.getParameter( "userType" ));
	    	client.setId(getIdStudentByEmail(request.getParameter( "emailAdress" )));
	    	
	    	return client;
	    }
}