package beans;

import java.util.HashMap;


public class Email {
	private int id;
	private String subject;
	private String content;
	private String from;
	private boolean isSeen;
	
	public Email(int id, String subject, String content, String from, boolean isSeen)
	{
		this.id  = id;
		this.subject = subject;
		this.content = content;
		this.from = from;
		this.isSeen = isSeen;
	}
	
	@Override 
	public String toString()
	{
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("\"subject\"", "\"" + subject + "\"");
		hash.put("\"content\"", "\"" + content + "\"");
		hash.put("\"from\"", "\"" + from + "\"");
		return hash.toString().replaceAll("=", ":");
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
