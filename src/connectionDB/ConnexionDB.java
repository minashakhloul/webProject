package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

	public ConnexionDB() {
		try {
			loadDriver();
			connect = newConnection();
			st = connect.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet selectData(String req) {
		try {
			return st.executeQuery(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertData(String req) {
		try {
			return st.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void destroy() throws SQLException {
		st.close();
		connect.close();
	}
}
