package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDB {

	public Connection connect;
	Statement st;

	void loadDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	Connection newConnection() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/polylife";
		Connection conn = DriverManager.getConnection(url, "root", "mina");
		return conn;
	}

	public ConnexionDB() throws ClassNotFoundException, SQLException {
		loadDriver();
		connect = newConnection();
	}
}
