package beans;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspWriter;

import connectionDB.ConnexionDB;

public class ProfilStudent implements Profil {

	private String firstname;
	private String lastname;
	private String age;
	private String birthDay;
	private String nationality;
	private String sex;
	private String email;
	private String phoneNumber;
	private String status;
	private String spe;
	private String promotion;
	private String year;
	
	public void setProfil(String mailAddress)
	{
		ConnexionDB connexion = new ConnexionDB();
		
		String req = "Select email, nom, prenom, dateDeNaissance, nationalite, sex, telephone, promotion, annee, nomStatusEtudiant, nomSpecialite"
				+ " from etudiant e, statusEtudiant se, specialite s "
				+ "WHERE e.idStatusEtudiant = se.idStatusEtudiant "
				+ "and e.idSpecialite = s.idSpecialite and"
				+ " email = '" + mailAddress + "'";
		System.out.println(req);
		ResultSet rs = connexion.selectData(req);
		
		try {
			while(rs.next())
			{
				lastname = rs.getString("nom");
				firstname = rs.getString("prenom");
				email = rs.getString("email");
				birthDay = rs.getString("dateDeNaissance");
				nationality = rs.getString("nationalite");
				sex = rs.getString("sex");
				phoneNumber = rs.getString("telephone");
				promotion = rs.getString("promotion");
				year = rs.getString("annee");
				status = rs.getString("nomStatusEtudiant");
				spe = rs.getString("nomSpecialite");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			out.println("<p> Nom : " + firstname + "</p>");
			out.println("<p> Prénom : " + lastname + "</p>");
			out.println("<p> Email : " + email + "</p>");
			out.println("<p> Date de Naissance : " + birthDay + "</p>");
			out.println("<p> Nationalité : " + nationality + "</p>");
			out.println("<p> Âge : " + age + "</p>");
			out.println("<p> Sexe : " + sex + "</p>");
			out.println("<p> Numéro de téléphone : " + phoneNumber + "</p>");
			out.println("<p> Statut : " + status + "</p>");
			out.println("<p> Spécialité : " + spe + "</p>");
			out.println("<p> Promotion : " + promotion + "</p>");
			out.println("<p> Année : " + year + "</p>");
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
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
	public String getSpe() {
		return spe;
	}
	public void setSpe(String spe) {
		this.spe = spe;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
