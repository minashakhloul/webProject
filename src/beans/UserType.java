package beans;

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
}
