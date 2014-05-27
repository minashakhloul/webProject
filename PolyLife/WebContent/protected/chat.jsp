<%@page import="beans.Chat"%>
<%@page import="beans.ChatConstants"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>PolyLife</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./inc/styleChat.css" rel="stylesheet">
</head>
<%!public String chatName;
	public int msgsSize;%>
<%
	Chat chat = (Chat) application.getAttribute(ChatConstants.APP_STATE);
	chatName = chat.getChatName();
	msgsSize = chat.getMsgs().size();
%>
<script> 
var chatName = "<%=chatName%>";
var msgsSize = "<%=msgsSize%>";
</script>
<body>
	<form action="/PolyLife/ChatServlet" method="post">
		<p>
			<textarea id="chat" name="chat" rows="13" cols="33">
				<%
					// Set the content of the textArea to the history.
					//assert(chat != null);
					for (int i = 0; i < chat.getMsgs().size(); i++) {
						out.println(chat.getMsgs().get(i).getUser().getFirstName() + " " + chat.getMsgs().get(i).getUser().getLastName() + " : "
								+ chat.getMsgs().get(i).getMsgText());
					}
				%>
			</textarea>
			<br /> I say: <input type="text" name="iSay" size="60" /> <br /> <input
				type="submit" value="Talk/Refresh" />
		</p>
	</form>
	<script src="/PolyLife/inc/bootstrap/js/chatNotificationScript.js" type="text/javascript"></script>
</body>
</html>

