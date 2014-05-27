package beans;

public class Email {
	private int id;
	private String subject;
	private String content;
	private String from;
	private boolean isSeen;
	
	public Email(String subject, String content, String from, boolean isSeen)
	{
		this.subject = subject;
		this.content = content;
		this.from = from;
		this.isSeen = isSeen;
	}

	public int getID(){
		return id;
	}
	public void setID(int id){
		this.id = id;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public boolean isSeen() {
		return isSeen;
	}

	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}
}
