<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Ajouter une offre d'emploi</title>
		<link type="text/css" rel="stylesheet" href="inc/styleAcceuil.css" />
		<script type="text/javascript" src="jobOfferScripts.js"></script>
			<script type="text/javascript" src="/PolyLife/inc/bootstrap/js/annoncementScripts.js"></script>
		<link type="text/css" rel="stylesheet" href="/PolyLife/inc/styleAcceuil.css" />
		<link type="text/css" rel="stylesheet" href="/PolyLife/inc/bootstrap.css" />
		<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/bootstrap/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="/PolyLife/inc/registrationStyle.css" />
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
			<li><a href="/PolyLife/protected/email/newEmail"> <c:out
						value="Email" />
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
		<div id="headcontentzone">
			<div class="page-container">
		
				<div class="hero-unit">
					<h2>Offre d'emploi</h2>
					<span id="spanParag">
						Ajouter une offre d'emploi afin de faire favoriser l'insertion professionnelle des étudiant de Polytech Paris-Sud
					</span>
				</div>
		
				<div class="container">
					
					<div class="row" align="center">
						<div class="span12">
							<div class="alert alert-success">
  								<strong>Succès!</strong> Votre offre d'emploi a bien été créé.
							</div>
						</div>
					</div>
					
					<div id="jobOfferResults">
					
						<div class="row">
						
							<div class="span5" align="left">
								
								<span> <strong class="strong"> Titre: </strong></span>
								<span> ${sessionScope.contract.getTitle()}</span>
								
								<br /><br />
								
								<span> <strong class="strong"> Date: </strong></span>
								<span> ${sessionScope.contract.getDate()}</span>
								
								<br /><br />
								
								<span> <strong class="strong"> A contacter: </strong></span>
								<span> ${sessionScope.contract.getEmailContact()}</span>
								
								<br /><br />
								
							</div>
							
							<div class="span5" align="left">
							
								<span> <strong class="strong"> Type du contract: </strong></span>
								<c:choose>
    								<c:when test="${sessionScope.contract.getContractType().getType() == 1}">Apprentissage</c:when>
    								<c:when test="${sessionScope.contract.getContractType().getType() == 2 }">Stage</c:when>
    								<c:otherwise>${sessionScope.contract.getContractType()}</c:otherwise>
								</c:choose>
									
								<br /><br />
									
								<span> <strong class="strong"> Rémunération: </strong></span>
								<c:if test="${ sessionScope.contract.getWage() == -1 }" var="maVariable" scope="session">
	    							Non définie
								</c:if>
								<c:if test="${ sessionScope.contract.getWage() != -1 }" var="maVariable" scope="session">
	    							${ sessionScope.contract.getWage()}
								</c:if>
								
							</div>
						</div>
						
						<br/>
						
						<div class="row">
							<div class="span10" align="left">
								<p> <strong class="strong"> Description: </strong> <br/>
										${sessionScope.contract.getDescription()}
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			<script src="/PolyLife/inc/bootstrap/js/OnlineUserNotificationScript.js"
	type="text/javascript"></script>	
	</body>
</html>