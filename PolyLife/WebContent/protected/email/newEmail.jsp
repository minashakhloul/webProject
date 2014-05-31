<%@ page import="java.util.*" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.email.DisplayMail" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New email</title>
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/styleAcceuil.css" />
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/bootstrap1.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<div class="navbar navbar-inverse">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-inverse-collapse"></button>
		<a class="navbar-brand" href="/PolyLife/protected/acceuil.jsp">PolyLife</a>
	</div>
	<div class="navbar-collapse collapse navbar-inverse-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/PolyLife/protected/acceuil.jsp">Accueil</a></li>
		</ul>
		<form class="navbar-form navbar-left">
			<input type="text" class="form-control col-lg-8" placeholder="Search">
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/PolyLife/protected/profil/profil.jsp">${user.getFirstName()}
					${user.getLastName()}</a></li>
			<li><a href="/PolyLife/protected/email/newEmail"> <c:out value="Email"/>
			</a></li>
			<li><a href="/PolyLife/ServletLogin?signOut=signOut">Sign
					out</a></li>
		</ul>
	</div>
</div>
<div id="sidebar-left">
	<p align="center" style="font-size:20px">Online Users</p>
	<div class="inside-sidebar">
		<table class="table table-striped table-hover " id="onlineUsers">
		</table>
	</div>
</div>
<div id="sidebar-right">
	<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">Annonces<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="/PolyLife/ListeAnnonces">Mes annonces</a></li>
				<li><a href="/PolyLife/protected/annoncementCreation.jsp">Créer
						annonce</a></li>
			</ul></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">Evènements<span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="/PolyLife/ListeEvenements">Mes évènements</a></li>
				<li><a href="/PolyLife/protected/eventCreation.jsp">Créer
						un évènement</a></li>
			</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">Offres d'emploi<span class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="/PolyLife/ListeOffresEmploi">Mes offres d'emploi</a></li>
				<li><a href="/PolyLife/protected/jobOfferCreation.jsp">Créer
						un offre d'emploi</a></li>
			</ul></li>
	</ul>
</div>

<%
	Object errorMessage = request.getAttribute("errorMessage");
	
	if(errorMessage != null)
	{	
	out.println("<span id='errorMessage' >" + errorMessage.toString() + "</span>");	
	}
	
	ArrayList<String> addressesList = DisplayMail.getEmailAddressesList();
%>
	<form action="/PolyLife/email/displayMail" method="post">
		<ul>
			<li>
				To : <input type="email" name="to" list="addresses_list" required>
				<datalist id="addresses_list">
				<%
					for(String s : addressesList)
					{
						out.println("<option label='" + s + "' value='" + s + "'/>");
					}
				%>
				</datalist>
			</li>
			<li>Subject : <input type="text" name="subject"></li>
			<li>Content : <textarea rows="15" cols="100" name="content"></textarea></li>
			<li><input type="submit" name="submit" value="Envoyer"></li>
		</ul>
	</form>
</body>
</html>