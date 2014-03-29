package beans;

public class Client {

	private String password;
	private String login;
	private String userType;

	public Client() {
		new Client(null, null, null);
	}

	public Client(String password, String login, String userType) {
		this.password = password;
		this.login = login;
		this.userType = userType;
	}

	public void setMotDePasse(String motDePasse) {
		this.password = motDePasse;
	}

	public String getMotDePasse() {
		return password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setlogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}
}