<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="beans.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	Profil p;
	String email = request.getParameter("mail");
	if(UserType.getTypeOfProfil(email).equals(UserType.STUDENT))
	{
		p = new ProfilStudent();
	}
	else
	{
		p = new ProfilProf();
	}
	
	
	p.setProfil(email);
%>

<title><%= p.getCompleteName() %></title>
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/styleAcceuil.css" />
</head>
<div id="header">
	<ul id="nav">
		<!-- -->
		<li><a href="/PolyLife/protected/acceuil.jsp">Accueil</a></li>
		<li><a href="/PolyLife/protected/profil/profil.jsp?mail=${utilisateur.getLogin()}">${utilisateur.getFirstName()} ${utilisateur.getLastName()}</a></li>
		<li><input type="text"><input type="submit"
			value="Chercher" /></li>
		<li><a href="/PolyLife/email/displayMail">
    			<c:out value="Email"/> 
			</a>
		</li> 
	</ul>
</div>


<body>
	<div style="text-align:center;">
	<% p.displayInfos(out); %>
	</div>
</body>
</html>