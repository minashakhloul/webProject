package beans;

public enum StudentStatus {
	
	APP(1),  CONTINUES_TRAINING(2), INITIAL_TRAINING(3), PEIP(4), EX(5);

	private int status;

	private StudentStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public static int getValueOf(StudentStatus status) {
		switch (status) {
		case APP:
			return APP.getStatus();
		case PEIP:
			return PEIP.getStatus();
		case INITIAL_TRAINING:
			return INITIAL_TRAINING.getStatus();
		case CONTINUES_TRAINING:
			return CONTINUES_TRAINING.getStatus();
		case EX:
			return EX.getStatus();
		default:
			return 0;
		}
	}

	public static StudentStatus getStatusOf(String status) {
		if (status.equals("apprenticeship"))
			return APP;
		if (status.equals("peip"))
			return PEIP;
		if (status.equals("initialTraining"))
			return INITIAL_TRAINING;
		if (status.equals("continuesTraining"))
			return CONTINUES_TRAINING;
		if (status.equals("exStudent"))
			return EX;
		return null;
	}
	
	
}
