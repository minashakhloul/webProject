
<%@ page import="java.util.*" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--<c:import url="W3C.jsp" />-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/styleAcceuil.css" />
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/bootstrap1.css" />
</head>
<!--<form class="well span6 myClass" method="get" action="acceuil" id="cssAcceuil">-->
<div class="navbar navbar-inverse">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-inverse-collapse"></button>
		<a class="navbar-brand" href="/PolyLife/protected/acceuil.jsp"><img src="/PolyLife/2.jpg" alt="PolyLife" height="30" width="50"></a>
	</div>
	<div class="navbar-collapse collapse navbar-inverse-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/PolyLife/protected/acceuil.jsp">Accueil</a></li>
		</ul>
		<form class="navbar-form navbar-left">
			<input type="text" class="form-control col-lg-8" placeholder="Search">
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/PolyLife/protected/profil.jsp">${user.getFirstName()}
					${user.getLastName()}</a></li>
			<li><a href="/PolyLife/email/displayMail"> <c:out
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
	<div class="inside-sidebar">Content</div>
	<div id="container" class="ui-notify">
		<!-- 	<div class="ui-notify-message ui-notify-message-style" style="">  -->
		<!-- 			<h1>A new user has just signed in !</h1>  -->
		<!--  	</div>  -->
	</div>
</div>
<div id="headcontentzone">
	<div class="event">
		<h2>Evenement X</h2>
		<div class="illustration">
			<img src="http://dummyimage.com/200x150/000/fff" width="200px"
				height="150px" />
		</div>
		<div class="text">
			<p>
				Ceci est un exemple d'information qui sera affiché<br /> Avec des
				infos qui la completerons
			</p>
		</div>
	</div>
</div>
<!--</form>-->
<script src="/PolyLife/inc/bootstrap/js/OnlineUserNotificationScript.js"
	type="text/javascript"></script>
</body>
</html>


