package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Client;
import beans.Contract;
import beans.ContractType;
import connectionDB.ConnexionDB;

public class ServletJobOfferCreation extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConnexionDB con = null;
	private final String creationJobOfferPage = "/protected/jobOfferCreation.jsp";
	private final String creationSuccessPage = "/protected/jobOfferSuccess.jsp";
	private final String registrationLink = "/PolyLife/inscription";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if(request.getSession().getAttribute("user") == null)
		// response.sendRedirect( registrationLink );
		// else
		this.getServletContext().getRequestDispatcher(creationJobOfferPage).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		con = new ConnexionDB();
		jobOfferCreation(request);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.getServletContext().getRequestDispatcher(creationSuccessPage).forward(request, response);
	}

	private void jobOfferCreation(HttpServletRequest request) {
		Contract contract = new Contract();
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("user");
		int idUser = client.getId();
		contract.setIdExStudent(idUser);
		String title = request.getParameter("title");
		contract.setTitle(title);
		String contractType = request.getParameter("contractType");
		ContractType type = ContractType.getTypeOf(contractType);
		contract.setContractType(type);
		int idcontractType = ContractType.getValueOf(type);
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		contract.setDate(day + " " + whichMonth(Integer.parseInt(month)) + " " + year);
		String wage = request.getParameter("wage");
		int wageValue;
		try {
			wageValue = Integer.parseInt(wage);
		} catch (NumberFormatException e) {
			wageValue = -1;
		}
		contract.setWage(wageValue);
		String emailContact = request.getParameter("emailContact");
		contract.setEmailContact(emailContact);
		String description = request.getParameter("description");
		contract.setDescription(description);
		String req = "INSERT INTO offreemploi (idEtudiant,titre,description,Date,idTypeContrat,remuneration,emailContact) " + "VALUES ('" + idUser
				+ "',\"" + title + "\",\"" + description + "\"," + "STR_TO_DATE('" + day + "." + month + "." + year + "','%d.%m.%Y')" + ",'"
				+ idcontractType + "','" + wageValue + "','" + emailContact + "')";
		con.insertData(req);
		session.setAttribute("contract", contract);
	}

	private String whichMonth(int idMonth) {
		if (idMonth < 0 || idMonth > 12)
			return "";
		String[] months = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" };
		return months[idMonth];
	}
}
