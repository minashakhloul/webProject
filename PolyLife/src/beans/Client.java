package beans;

import java.util.Date;

public class Client {

	private String password;
	private String login;
	private UserType userType;
	private String firstName;
	private String lastName;

	public void setMotDePasse(String motDePasse) {
		this.password = motDePasse;
	}

	public String getMotDePasse() {
		return password;
	}

	public String getUserType() {
		return userType.getType();
	}

	public void setUserType(String userType) {
		this.userType = UserType.getTypeOf(userType);
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}