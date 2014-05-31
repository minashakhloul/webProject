<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter une offre d'emploi</title>
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/styleAcceuil.css" />
<script type="text/javascript"
	src="/PolyLife/inc/bootstrap/js/jobOfferScripts.js"></script>
<script type="text/javascript"
	src="/PolyLife/inc/bootstrap/js/annoncementScripts.js"></script>
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/styleAcceuil.css" />
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/bootstrap.css" />

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
			data-toggle="dropdown" href="#">Offres d'emploi<span
				class="caret"></span>
		</a>
			<ul class="dropdown-menu">
				<li><a href="/PolyLife/ListeOffresEmploi">Mes offres
						d'emploi</a></li>
				<li><a href="/PolyLife/protected/jobOfferCreation.jsp">Créer
						un offre d'emploi</a></li>
			</ul></li>
	</ul>
</div>
<div id="headcontentzone">
	<div class="page-container">

		<div class="hero-unit">
			<h2>Offre d'emploi</h2>
			<span id="spanParag"> Ajouter une offre d'emploi afin de faire
				favoriser l'insertion professionnelle des étudiant de Polytech
				Paris-Sud </span>
		</div>

		<div class="container">

			<div id="jobOfferForm">

				<form class="form-horizontal" name="jobOfferForm" method="post"
					action="creerOffreEmploi" onsubmit="return jobOfferCreationOK();">

					<div class="row">
						<div class="span6">
							<div id="titleErrorColor" class="">
								<label class="control-label" for="title">Titre <span
									class="required">*</span>
								</label>
								<div class="controls">
									<input type="text" id="title" name="title"
										placeholder="Offre d'emploi" value="" size="100"
										maxlength="100" /> <br /> <span id="titleError"
										class="error"></span>
								</div>
							</div>
						</div>
						<div class="span6">
							<div id="contractTypeErrorColor" class="">
								<label class="control-label" for="contractType">Type du
									contract <span class="required">*</span>
								</label>
								<div class="controls">
									<select name="contractType" id="contractType">
										<option value="">choisir un type</option>
										<option value="app">Apprentissage</option>
										<option value="internship">Stage</option>
										<option value="cdd">CDD</option>
										<option value="cdi">CDI</option>
									</select> <br /> <span id="contractTypeError" class="error"></span>
								</div>
							</div>
						</div>
					</div>

					<br />

					<div class="row">
						<div class="span6">
							<div id="dateErrorColor" class="">
								<label class="control-label" for="date">Date <span
									class="required">*</span>
								</label>
								<div class="controls">
									<select class="dateForm" name="day" id="day">
										<option value="">Jour</option>
									</select> <select class="dateForm" name="month" id="month">
										<option value="">Mois</option>
									</select> <select class="dateForm" name="year" id="year">
										<option value="">Année</option>
									</select> <br /> <span id="dateError" class="error"></span>
								</div>
							</div>
						</div>
						<div class="span6">
							<div id="wageErrorColor" class="">
								<label class="control-label" for="wage">Rémunération </label>
								<div class="controls">
									<input type="number" id="wage" name="wage" value=""
										placeholder="Euros/Mois" size="10" maxlength="10" /> <br />
									<span id="wageError" class="error"></span>
								</div>
							</div>
						</div>
					</div>

					<br />

					<div class="row">
						<div class="span12">
							<div id="emailContactErrorColor" class="">
								<label class="control-label" for="emailContact">A
									contacter <span class="required">*</span>
								</label>
								<div class="controls">
									<input type="email" id="emailContact" name="emailContact"
										value="" placeholder="contact@exemple.exp" size="50"
										maxlength="50" /> <br /> <span id="emailContactError"
										class="error"></span>
								</div>
							</div>
						</div>
					</div>

					<br />

					<div class="row">
						<div class="span12">
							<div id="descriptionErrorColor" class="">
								<label class="control-label" for="description">Description
								</label>
								<div class="controls">
									<textarea rows="10" maxlength="1000" id="description"
										name="description"> </textarea>
									<span id="descriptionError" class="error"></span>
								</div>
							</div>
						</div>
					</div>

					<br />

					<div class="row">
						<div class="span12" align="center">
							<div class="controls">
								<input type="submit" class="btn btn-primary" value="Créer" /> <input
									type="reset" class="btn btn-primary" value="Réinitialiser" />
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>
<script src="/PolyLife/inc/bootstrap/js/OnlineUserNotificationScript.js"
	type="text/javascript"></script>
</body>
</html>