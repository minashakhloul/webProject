package beans;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/protected/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		Object user = session.getAttribute("utilisateur");
		if (session == null || session.getAttribute("utilisateur") == null) {
			// No logged-in user found, so redirect to login page.
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		} else {
			chain.doFilter(req, resp); // Logged-in user found, so just continue
										// request.
		}
	}
}
