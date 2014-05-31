package beans;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspWriter;

import connectionDB.ConnexionDB;

public class ProfilProf implements Profil{

	private String firstname;
	private String lastname;
	private String sex;
	private String email;
	private String phoneNumber;
	private String status;
	
	@Override
	public void setProfil(String mailAddress) {
		
		ConnexionDB connexion = new ConnexionDB();
	
		String req = "Select nom, prenom, email, dateDeNaissance, sex, telephoneBureau, s.nomStatutProf"
				+ " from professeur p, statusProf s"
				+ "WHERE p.idStatusProf = s.idStatusProf "
				+ "and email = '" + email + "'";
		ResultSet rs = connexion.selectData(req);
		
		try {
			while(rs.next())
			{
				lastname = rs.getString("nom");
				firstname = rs.getString("prenom");
				email = rs.getString("email");
				sex = rs.getString("sex");
				phoneNumber = rs.getString("telephone");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getUser()
	{
		return email;
	}
	
	@Override
	public String getCompleteName()
	{
		return firstname + " " + lastname;
	}
	
	@Override
	public void displayInfos(JspWriter out)
	{
		try {
			out.println("<p>" + firstname + "</p>");
			out.println("<p>" + lastname + "</p>");
			out.println("<p>" + email + "</p>");
			out.println("<p>" + sex + "</p>");
			out.println("<p>" + email + "</p>");
			out.println("<p>" + phoneNumber + "</p>");
			out.println("<p>" + status + "</p>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
}
