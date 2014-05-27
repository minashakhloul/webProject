<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.email.DisplayMail" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New email</title>
</head>
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