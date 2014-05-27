<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Poster une annonce</title>
		<link type="text/css" rel="stylesheet" href="inc/styleAcceuil.css" />
		<script type="text/javascript" src="annoncementScripts.js"></script>
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
					<h2>Annonces</h2>
					<span id="spanParag">Postez des annonces et partager les avec l'ensemble des étudiants de Polytech.</span>
				</div>
		
				<div class="container">
					
					<div id="eventForm">	 	
						<form class="form-horizontal" name="annoncementForm" method="post" action="creerAnnonce" onsubmit="return annoncementCreationOK();" enctype="multipart/form-data" >
							
							<div class="row">
								<div  class="span5">
									<div id="titleErrorColor" class="">
										<label class="control-label" for="title">Titre <span class="required">*</span> </label>
										<div class="controls">
											<input type="text" id="title" name="title" value="" size="100" maxlength="100" />
											<br/> 
											<span id="titleError" class="error"></span>
										</div>
									</div>
								</div>
								<div  class="span5">
									<div id="imgAnnoncementErrorColor" class="">
										<label class="control-label" for="imgAnnoncement">Image </label>
										<div class="controls">
											<input type="file" id="imgAnnoncement" name="imgAnnoncement"  size="20" maxlength="20" /> 
											<br/>
											<span id="imgAnnoncementError" class="error"></span>
										</div>
									</div>
								</div>
							</div>
							
							<br />
							
							<div class="row">
								<div  class="span10">
									<div id="priceErrorColor" class="">
										<label class="control-label" for="price">Prix </label>
										<div class="controls">
											<input type="Number" id="price" name="price" value="" size="11" maxlength="11" /> 
											<br/>
											<span id="priceError" class="error"></span>
										</div>
									</div>
								</div>
							</div>
							
							<br />
							
							<div class="row">
								<div  class="span10">
									<div id="descriptionErrorColor" class="">
										<label class="control-label" for="description">Description </label>
										<div class="controls">
											<textarea rows="8" cols="10" maxlength="1000" id="description" name="description" > </textarea>
											<br/>
											<span id="descriptionError" class="error"></span>
										</div>
									</div>
								</div>
							</div>
							
							<br />
							
							<div class="row">
								<div class="span10" align="center">
									<div class="controls" >
										<input type="submit" class="btn btn-primary" value="Créer" />
										<input type="reset" class="btn btn-primary" value="Réinitialiser" />
									</div>
								</div>
							</div>
						</form>	
					</div>
				</div>
			</div>
		</div>
	</body>
</html>