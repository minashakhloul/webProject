package beans;

import java.sql.Time;


public class Message {

	private String msgText;
	private Client user;
	private Time msgTime;

	public Message(String msgText, Client user, Time msgTime) {
		this.msgText = msgText;
		this.user = user;
		this.msgTime = msgTime;
	}

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	public Client getUser() {
		return user;
	}

	public void setUser(Client user) {
		this.user = user;
	}

	public Time getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Time msgTime) {
		this.msgTime = msgTime;
	}
}
