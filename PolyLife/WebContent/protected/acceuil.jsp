
<%@ page import="java.util.*" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--<c:import url="W3C.jsp" />-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link type="text/css" rel="stylesheet" href="inc/styleAcceuil.css" />
</head>
<!--  <body background="./inc/background-nightlights.jpg"	style="background-repeat: no-repeat">-->
<!--<form class="well span6 myClass" method="get" action="acceuil" id="cssAcceuil">-->
<div id="header">
	<ul id="nav">
		<!-- -->
		<li><a href="/protected/acceuil.jsp">Accueil</a></li>
		<li><a href="/protected/profil.jsp">${utilisateur.getFirstName()} ${utilisateur.getLastName()}</a></li>
		<li><input type="text"><input type="submit"
			value="Chercher" /></li>
		<li><a href="/PolyLife/email/displayMail">
    			<c:out value="Email"/> 
			</a>
		</li> 
	</ul>
</div>
<div id="sidebar-left">
	<div class="inside-sidebar">Content</div>
</div>
<div id="sidebar-right">
	<div class="inside-sidebar">Content</div>
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
</body>

</html>


