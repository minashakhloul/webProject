
<%@ page import="java.util.*" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--<c:import url="W3C.jsp" />-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/styleAcceuil.css" />
</head>
<!--  <body background="./inc/background-nightlights.jpg"	style="background-repeat: no-repeat">-->
<!--<form class="well span6 myClass" method="get" action="acceuil" id="cssAcceuil">-->
<div id="header">
	<ul id="nav">
		<!-- -->
		<li><a href="/PolyLife/protected/acceuil.jsp">Accueil</a></li>
		<li><a href="/PolyLife/protected/profil/profil.jsp?mail=${utilisateur.getLogin()}">${utilisateur.getFirstName()} ${utilisateur.getLastName()}</a>
			<li>
		<li><a href="/PolyLife/protected/chat.jsp">Chat</a></li>
		<li><input type="text"><input type="submit"
			value="Chercher" /></li>
	</ul>
</div>
<div id="sidebar-left">
	<div class="inside-sidebar">
		Online Users<br>
		<p>
			<c:forEach items="${onlineUsers}" var="onlineUsers">
				<c:out
					value="${onlineUsers.value.getFirstName()} ${user.getLastName()}">4
				</c:out>
			</c:forEach>
		</p>
	</div>
</div>
<div id="sidebar-right">
	<ul>
		<li><a href="/PolyLife/ListeAnnonces">Lister les annonces</a></li>
		<li><a href="/PolyLife/protected/creerAnnonce.jsp">Cr�er annonce</a></li>
		<li><a href="/PolyLife/protected/modifierAnnonce.jsp">Modifier une annonce</a></li>
		<li><a href="/PolyLife/protected/listEvenement.jsp">Lister les annonces</a></li>
		<li><a href="/PolyLife/creerEvenement">Cr�er un �v�nement</a></li>
		<li><a href="/PolyLife/protected/modifierEvenement.jsp">Modifier �v�nement</a></li>
	</ul>
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
				Ceci est un exemple d'information qui sera affich�<br /> Avec des
				infos qui la completerons
			</p>
		</div>
	</div>
</div>
<!--</form>-->
</body>

</html>


