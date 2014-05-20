<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/protected/W3C.jsp" />
<body background="./inc/background-nightlights.jpg"	style="background-repeat: no-repeat">
	<form class="well span6 myClass" method="post" action="connexion" id="csslogin">
		<h4>Sign in </h4>
		<label>Username :</label>
		<input type="text" class="span3"align="middle" placeholder="Login..." id="email" name="email"/>
		<label>Password :</label>
		<input type="password" class="span3" align="middle"placeholder="Password..." id="password" name="password" /></br>
		<select name="userType" id="type">
			<option value="student">STUDENT</option>
			<option value="exStudent">EX STUDENT</option>
			<option value="professor">PROFESSOR</option>
		</select></br>
		<input type="submit" class="btn btn-primary" value="Submit" align="right" />
		<input type="reset" class="btn" name="cancel" value="Cancel" align="left" />
	</form>
</body>
</html>

