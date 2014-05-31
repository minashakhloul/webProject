<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Créer un evenement</title>
<link type="text/css" rel="stylesheet" href="inc/styleAcceuil.css" />
<script type="text/javascript" src="eventScripts.js"></script>
<script type="text/javascript"
	src="/PolyLife/inc/bootstrap/js/annoncementScripts.js"></script>
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/styleAcceuil.css" />
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/bootstrap.css" />
	<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/registrationStyle.css" />
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
	<p align="center" style="font-size: 20px">Online Users</p>
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
			<h2>Evenements</h2>
			<span id="spanParag"> Creer un évenement que vous partagerez
				avec l'ensemble des étudiants de Polytech. </span>
		</div>

		<div class="container">

			<div class="row" align="center">
				<div class="span12">
					<div class="alert alert-success">
						<strong>Succès!</strong> Votre évenement a bein été créé.
					</div>
				</div>
			</div>


			<div class="row">

				<div class="span6" align="left">

					<div id="eventResults">

						<span> <strong class="strong"> Titre: </strong>${sessionScope.event.getTitle()}
						</span> <br />
						<br /> <span> <strong class="strong"> Date: </strong>
							${sessionScope.event.getDate()}
						</span> <br />
						<br /> <span> <strong class="strong"> Heure: </strong>
							${sessionScope.event.getTime()} UTC + 2
						</span> <br />
						<br />

						<p>
							<strong class="strong"> Description: </strong> <br />
							${sessionScope.event.getDescription()}
						</p>
					</div>

				</div>

				<div class="span6" align="center">

					<div class="controls">
						<img id="myImg"
							src="<%=request.getContextPath()%>/img/events/${sessionScope.event.getEventFilePath()}"
							alt="${sessionScope.event.getTitle()}" />
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