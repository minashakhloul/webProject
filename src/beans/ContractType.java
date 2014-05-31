package beans;

public enum ContractType {
	
	APP(1),  INTERNSHIP(2), CDD(3), CDI(4);
	
	private int type;

	private ContractType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public static int getValueOf(ContractType type) {
		switch (type) {
		case APP:
			return APP.getType();
		case INTERNSHIP:
			return INTERNSHIP.getType();
		case CDD:
			return CDD.getType();
		case CDI:
			return CDI.getType();
		default:
			return 0;
		}
	}
	
	public static ContractType getTypeOf(String type) {
		if (type.equals("app"))
			return APP;
		if (type.equals("internship"))
			return INTERNSHIP;
		if (type.equals("cdd"))
			return CDD;
		if (type.equals("cdi"))
			return CDI;
		return null;
	}

}
