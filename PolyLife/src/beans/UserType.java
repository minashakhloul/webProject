package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import connectionDB.ConnexionDB;

public enum UserType {
	STUDENT("student"), EX_STUDENT("exStudent"), PROFESSOR("professor");

	private String type;

	private UserType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static String getValueOf(UserType utype) {
		switch (utype) {
		case STUDENT:
			return STUDENT.getType();
		case EX_STUDENT:
			return EX_STUDENT.getType();
		case PROFESSOR:
			return PROFESSOR.getType();
		default:
			return null;
		}
	}

	public static UserType getTypeOf(String type) {
		if (type.equals("student"))
			return STUDENT;
		else if (type.equals("exStudent"))
			return EX_STUDENT;
		else
			return PROFESSOR;
	}
	
	public static UserType getTypeOfProfil(String email)
	{
		ConnexionDB co = new ConnexionDB();
		
		String req = "select * from etudiant where email = '" + email + "'";
		System.out.println(req);

		ResultSet rs = co.selectData(req);
		
		try {
			if(rs.next())
			{
				return STUDENT;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PROFESSOR;
	}
}
