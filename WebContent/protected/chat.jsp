<%@page import="beans.*"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>PolyLife</title>
<meta charset="utf-8">

<link href="/PolyLife/inc/styleChat.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="/PolyLife/inc/bootstrap.css" />
</head>
<%!public String chatName;
	public int msgsSize;
	public String friendName;%>
<%
	Chat chat = (Chat) session.getAttribute("chat");
	chatName = chat.getChatName();
	msgsSize = chat.getMsgs().size();
	friendName = "";
	Client me = (Client) session.getAttribute("user");
	for(Integer key : chat.getFriendsFromDiscussion().keySet()){
		Client friend = chat.getFriendsFromDiscussion().get(key);
		if(friend.compareTo(me) != 1)
	friendName += chat.getFriendsFromDiscussion().get(key).getFirstName()+" "+chat.getFriendsFromDiscussion().get(key).getLastName();
	}
%>
<script> 
var chatName = "<%=chatName%>";
var msgsSize = "<%=msgsSize%>";
</script>
<body>
	<div class="navbar navbar-inverse">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-inverse-collapse"></button>
			<a class="navbar-brand" href="/PolyLife/protected/acceuil.jsp">PolyLife</a>
		</div>
		<div class="navbar-collapse collapse navbar-inverse-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/PolyLife/protected/acceuil.jsp">Accueil</a></li>
			</ul>
			<form class="navbar-form navbar-left">
				<input type="text" class="form-control col-lg-8"
					placeholder="Search">
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
	<div id="wrapper">
		<div id="menu">
			<p class="welcome">
				<b><%=friendName%></b>
			</p>
			<p class="logout">
				<a id="exit" href="/PolyLife/protected/acceuil.jsp">Exit Chat</a>
			</p>
		</div>
		<textarea id="chat" readonly>
		</textarea>

		<form name="message" action="/PolyLife/ChatServlet" method="post">
			<input name="iSay" type="text" id="usermsg" size="63" /> <input
				name="submitmsg" type="submit" id="submitmsg" value="Send" /> <br />
			<input type="hidden" name="chatId" value="<%=chat.getChatName()%>" />
		</form>
		</div>
	<script src="/PolyLife/inc/bootstrap/js/chatNotificationScript.js"
		type="text/javascript"></script>
</body>
</html>

