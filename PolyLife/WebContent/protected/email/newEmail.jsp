<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New email</title>
</head>
<body>

<%
	String errorMessage = request.getParameter("error");
	if(errorMessage != null && !errorMessage.isEmpty())
	{
%>	
	<span id="errorMessage"><% errorMessage.toString(); %></span>	
<%
	}
%>
	<form action="/PolyLife/email/displayMail" method="post">
		<ul>
			<li>To : <input type="text" name="to"></li>
			<li>Subject : <input type="text" name="subject"></li>
			<li>Content : <textarea rows="15" cols="100" name="content"></textarea></li>
			<li><input type="submit" name="submit" value="submit"></li>
		</ul>
	</form>
</body>
</html>