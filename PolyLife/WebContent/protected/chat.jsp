<%@page import="beans.*"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>PolyLife</title>
<meta charset="utf-8">

<link href="/PolyLife/inc/styleChat.css" rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/styleAcceuil.css" />
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/bootstrap/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="/PolyLife/inc/bootstrap.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
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
	<div id="sidebar-right">
		<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Annonces<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/PolyLife/ListeAnnonces">Mes annonces</a></li>
					<li><a href="/PolyLife/protected/annoncementCreation.jsp">Créer
							annonce</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Evènements<span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="/PolyLife/ListeEvenements">Mes évènements</a></li>
					<li><a href="/PolyLife/protected/eventCreation.jsp">Créer
							un évènement</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Offres d'emploi<span
					class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="/PolyLife/ListeOffresEmploi">Mes offres
							d'emploi</a></li>
					<li><a href="/PolyLife/protected/jobOfferCreation.jsp">Créer
							un offre d'emploi</a></li>
				</ul></li>
		</ul>
	</div>
	<div id="headcontentzone">
		<div class="page-container">

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
		</div>
	</div>
	<script src="/PolyLife/inc/bootstrap/js/chatNotificationScript.js"
		type="text/javascript"></script>
</body>
</html>

