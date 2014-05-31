package beans;

import javax.servlet.jsp.JspWriter;

public interface Profil {

	public void setProfil(String mailAddress);
	
	public String getCompleteName();
	
	public void displayInfos(JspWriter out);
	
	public String getUser();
}
