package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
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
import beans.ChatConstants;
import beans.Client;
import beans.Message;

public class ChatServlet extends HttpServlet implements ChatConstants {

	private static final long serialVersionUID = 1L;
	private HashMap<String, Chat> chatList = new HashMap<String, Chat>();
	public static String HISTORY_PATH = "/home/mina/ProjectDomo/history.xml";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("utilisateur");
		Chat chatObject = (Chat) context.getAttribute(APP_STATE);
		String iSay = request.getParameter("iSay");
		if (iSay != null) {
			iSay = iSay.trim();
			if (iSay.length() != 0) {
				synchronized (chatObject) {
					setChatList(chatObject, client, iSay);
				}
			}
		}
		try {
			saveChatIntoFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		context.setAttribute(APP_STATE, chatObject);
		RequestDispatcher rd = context.getRequestDispatcher("/protected/chat.jsp");
		rd.forward(request, response);
	}

	void setChatList(Chat chatObject, Client client, String iSay) {
		String keyName = null;
		if (chatList.size() == 0) {
			chatObject.getMsgs().add(new Message(iSay, client, new Time(new Date().getTime())));
			chatList.put("C" + chatList.size(), chatObject);
		} else {
			for (String s : chatList.keySet()) {
				if (chatList.get(s).compareTo(chatObject) == 1) {
					keyName = s;
				} else {
					keyName = "C" + chatList.size();
				}
			}
			if (keyName != null) {
				chatObject.setChatName(keyName);
				chatObject.getMsgs().add(new Message(iSay, client, new Time(new Date().getTime())));
				chatList.put(keyName, chatObject);
			}
		}
	}

	public void saveChatIntoFile() throws Exception {
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
