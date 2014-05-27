<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.email.DisplayMail" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New email</title>
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