package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import beans.Chat;
import beans.ChatApplication;
import beans.ChatConstants;
import beans.Client;
import beans.Message;

public class ChatServlet extends HttpServlet implements ChatConstants {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		String friendFirstName = request.getParameter("firstName");
		String friendLastName = request.getParameter("lastName");
		String chatId = request.getParameter("chatId");
		Client client = (Client) session.getAttribute("user");
		String iSay = request.getParameter("iSay");
		ChatApplication chatApplication = (ChatApplication) context.getAttribute(APP_STATE);
		HashMap<String, Chat> chatList = chatApplication.getListOfChats();
		ArrayList<Client> onlineUsers = (ArrayList<Client>) session.getAttribute("onlineUsers");
		Client myFriend = null;
		if (friendFirstName != null && friendLastName != null)
			try {
				myFriend = getMyFriend(friendFirstName, friendLastName, onlineUsers);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		Chat chatObject = getOurConversation(myFriend, chatList, chatId, client);
		if (iSay != null) {
			iSay = iSay.trim();
			if (iSay.length() != 0) {
				addMessageToconversation(chatObject, client, iSay);
				refreshChatList(chatObject, chatList);
			}
		}
		try {
			saveChatIntoFile(chatList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		chatApplication.setListOfChats(chatList);
		context.setAttribute(APP_STATE, chatApplication);
		session.setAttribute("chat", chatObject);
		context.getRequestDispatcher("/protected/chat.jsp").forward(request, response);
	}

	private Chat getOurConversation(Client myFriend, HashMap<String, Chat> chatList, String chatName, Client me) {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date today = Calendar.getInstance().getTime();
		String name = df.format(today);
		HashMap<Integer, Client> listOfFriends = new HashMap<Integer, Client>();
		if (myFriend != null) {
			listOfFriends.put(myFriend.getId(), myFriend);
			listOfFriends.put(me.getId(), me);
			Chat chat = null;
			for (String s : chatList.keySet()) {
				HashMap<Integer, Client> friendsFromDiscussion = new HashMap<Integer, Client>();
				friendsFromDiscussion = chatList.get(s).getFriendsFromDiscussion();
				// print(friendsFromDiscussion);
				// print(listOfFriends);
				if (isEqualTo(listOfFriends, friendsFromDiscussion)) {
					chat = chatList.get(s);
					break;
				}
			}
			if (chat == null) {
				chat = new Chat("C" + name);
				chat.addFriendToDiscussion(myFriend);
				chat.addFriendToDiscussion(me);
				chatList.put(chat.getChatName(), chat);
			}
			return chat;
		} else
			return chatList.get(chatName);
	}

	private void print(HashMap<Integer, Client> friends) {
		System.out.println("Friends are:");
		for (Client c : friends.values()) {
			System.out.println(c.getFirstName() + " " + c.getLastName());
		}
	}

	private boolean isEqualTo(HashMap<Integer, Client> listOfFriends, HashMap<Integer, Client> friendsFromDiscussion) {
		boolean equal = false;
		if (listOfFriends.size() != friendsFromDiscussion.size())
			return equal;
		else {
			if (listOfFriends.keySet().equals(friendsFromDiscussion.keySet()))
				equal = true;
			/*
			 * for (String login : listOfFriends.keySet()) { if
			 * (friendsFromDiscussion.containsKey(login)) equal = true; else
			 * equal = false; }
			 */
		}
		return equal;
	}

	private Client getMyFriend(String friendFirstName, String friendLastName, ArrayList<Client> onlineUsers) throws Exception {
		Client c = null;
		for (Client client : onlineUsers) {
			if (client.getFirstName().equals(friendFirstName) && client.getLastName().equals(friendLastName)) {
				c = client;
				break;
			}
		}
		if (c == null)
			throw new Exception();
		return c;
	}

	private void refreshChatList(Chat chatObject, HashMap<String, Chat> chatList) {
		chatList.put(chatObject.getChatName(), chatObject);
	}

	private void addMessageToconversation(Chat chatObject, Client client, String iSay) {
		chatObject.getMsgs().add(new Message(iSay, client, new Time(new Date().getTime())));
	}

	private void saveChatIntoFile(HashMap<String, Chat> chatList) throws Exception {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("ChatHistory");
		doc.appendChild(rootElement);
		for (String s : chatList.keySet()) {
			Element chat = doc.createElement(s);
			rootElement.appendChild(chat);
			for (Message m : chatList.get(s).getMsgs()) {
				Element message = doc.createElement(m.getUser().getFirstName() + m.getUser().getLastName());
				message.setTextContent(m.getMsgText());
				chat.appendChild(message);
			}
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(HISTORY_PATH));
		transformer.transform(domSource, result);
	}
}
