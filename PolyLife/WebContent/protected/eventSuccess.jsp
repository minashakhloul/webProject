<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Créer un evenement</title>
		<link type="text/css" rel="stylesheet" href="inc/styleAcceuil.css" />
		<script type="text/javascript" src="eventScripts.js"></script>
		<script type="text/javascript" src="inc/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript" src="inc/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="inc/bootstrap/js/jquery-2.0.0.min.js"></script>
		
		<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap-responsive.css" />
		<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap-responsive.min.css" />
		<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap.css" />
		<link type="text/css" rel="stylesheet" href="inc/bootstrap/css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="inc/registrationStyle.css" />
		
	</head>
	<body>
		<div id="header">
			<ul id="nav">
				<li><a href="/protected/acceuil.jsp">Accueil</a></li>
				<li><a href="/protected/profil.jsp">
				
				${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</a></li>
				<li><input type="text"><input type="submit" value="Chercher" /></li>
				<li><a href="/PolyLife/email/displayMail"> <c:out value="Email" /> </a></li>
			</ul>
		</div>
		<div id="sidebar-left">
			<div class="inside-sidebar">Content</div>
		</div>
		<div id="sidebar-right">
			<div class="inside-sidebar">Content</div>
		</div>
		<div id="headcontentzone">
			<div class="page-container">
		
				<div class="hero-unit">
					<h2>Evenements</h2>
					<span id="spanParag">
						Creer un évenement que vous partagerez avec l'ensemble des étudiants de Polytech.
					</span>
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
								
								<span> <strong class="strong"> Titre: </strong>${sessionScope.event.getTitle()}</span>
								
								<br /><br />
								
								<span> <strong class="strong"> Date: </strong> ${sessionScope.event.getDate()}</span>
								
								<br /><br />
								
								<span> <strong class="strong"> Heure: </strong> ${sessionScope.event.getTime()} UTC + 2 </span>
								
								<br /><br />
								
								<p> <strong class="strong"> Description: </strong> <br/>
									${sessionScope.event.getDescription()}
								</p>
							</div>
							
						</div>
						
						<div class="span6" align="center">
						
							<div class="controls">
								<img id="myImg" src="<%=request.getContextPath()%>/img/events/${sessionScope.event.getEventFilePath()}" alt="${sessionScope.event.getTitle()}" />
							</div>
							
							
						</div>
						
					</div>
					
				</div>
			</div>
		</div>
				
	</body>
</html>