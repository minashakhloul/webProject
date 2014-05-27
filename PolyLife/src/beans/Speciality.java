package beans;

public enum Speciality {
	
	INFO(1),  MTX(2), EES(3), PSO(4), SANS(5);

	private int speciality;

	private Speciality(int speciality) {
		this.speciality = speciality;
	}

	public int getSpeciality() {
		return speciality;
	}

	public static int getValueOf(Speciality spe) {
		if(spe == null) return 0;
		
		switch (spe) {
		case INFO:
			return INFO.getSpeciality();
		case MTX:
			return MTX.getSpeciality();
		case EES:
			return EES.getSpeciality();
		case PSO:
			return PSO.getSpeciality();
		case SANS:
			return SANS.getSpeciality();
		default:
			return 0;
		}
	}

	public static Speciality getStatusOf(String speciality) {
		if (speciality.equals("info"))
			return INFO;
		if (speciality.equals("mtx"))
			return MTX;
		if (speciality.equals("ees"))
			return EES;
		if (speciality.equals("pso"))
			return PSO;
		if (speciality.equals(""))
			return SANS;
		return null;
	}
	
	
}
