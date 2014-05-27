package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ChatNotificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chatName = request.getParameter("chatName");
		System.out.println(chatName);
		int size = Integer.parseInt(request.getParameter("nbMsg"));
		PrintWriter out = response.getWriter();
		out.println(getUnviewedMsgs(chatName, size));
	}

	private String getUnviewedMsgs(String chatName, int size) {
		String str = "";
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(ChatServlet.HISTORY_PATH));
			if (doc.getElementById(chatName) != null) {
				NodeList childNodes = doc.getElementById(chatName).getChildNodes();
				if (childNodes.getLength() == size)
					str = "";
				else {
					for (int i = 0; i < childNodes.getLength(); i++) {
						str += childNodes.item(i).getTextContent() + "\n";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
