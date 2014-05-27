package beans;

import java.util.ArrayList;

public class Chat implements Comparable<Chat> {

	/** The list of messages */
	private ArrayList<Message> msgs;
	private String ChatName;

	public Chat(String name) {
		msgs = new ArrayList<Message>();
		ChatName = name;
	}

	public String getChatName() {
		return ChatName;
	}

	public void setChatName(String chatName) {
		ChatName = chatName;
	}

	public ArrayList<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(ArrayList<Message> msgs) {
		this.msgs = msgs;
	}

	public ArrayList<Client> getUsers() {
		ArrayList<Client> users = new ArrayList<Client>();
		for (Message m : msgs) {
			if (!users.contains(m.getUser()))
				users.add(m.getUser());
		}
		return users;
	}

	@Override
	public int compareTo(Chat c) {
		if (msgs.size() == c.getMsgs().size()) {
			boolean equal = false;
			int i = 0;
			for (Message m : msgs) {
				equal = m.getMsgText().equals(c.getMsgs().get(i).getMsgText());
				equal = m.getUser().getLogin().equals(c.getMsgs().get(i).getUser().getLogin());
				equal = m.getMsgTime().equals(c.getMsgs().get(i).getMsgTime());
				i++;
				if (!equal)
					return 0;
			}
			return 1;
		}
		return -1;
	}
}
