package beans;

public class Client implements Comparable<Client> {

	private String password;
	private String login;
	private UserType userType;
	private String firstName;
	private String lastName;
	private int id;

	public Client() {
	}

	public Client(String password, String login, UserType userType, String firstName, String lastName) {
		super();
		this.password = password;
		this.login = login;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Client(String password, String login, UserType userType, String firstName, String lastName, int id) {
		this(password, login, userType, firstName, lastName);
		this.id = id;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Client c) {
		if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName))
			return 1;
		else
			return 0;
	}
}