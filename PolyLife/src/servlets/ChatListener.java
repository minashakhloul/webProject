package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import beans.Chat;
import beans.ChatConstants;

public class ChatListener implements ChatConstants, HttpSessionListener, ServletContextListener {

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		HttpSession sess = e.getSession();
		ServletContext ctx = sess.getServletContext();
		ctx.setAttribute("utilisateur", sess.getAttribute("utilisateur"));
		System.out.println("Chat User Set Up");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		HttpSession session = e.getSession();
		System.out.println("Chat User Removed");
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext ctx = e.getServletContext();
		ctx.setAttribute(APP_STATE, new Chat(new String("C")));
		System.out.println("Chat Application Initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		System.out.println("Chat Application Destroyed");
	}
}
