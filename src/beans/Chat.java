package beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Chat implements Comparable<Chat> {

	/** The list of messages */
	private ArrayList<Message> msgs;
	private String ChatName;
	private HashMap<Integer, Client> friends;

	public Chat(String name) {
		msgs = new ArrayList<Message>();
		friends = new HashMap<Integer, Client>();
		ChatName = name;
	}

	public String getChatName() {
		return ChatName;
	}

	public void setChatName(String chatName) {
		ChatName = chatName;
	}

	public void addFriendToDiscussion(Client c) {
		if (!friends.containsKey(c.getId()))
			friends.put(c.getId(), c);
	}

	public HashMap<Integer, Client> getFriendsFromDiscussion() {
		return friends;
	}

	public ArrayList<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(ArrayList<Message> msgs) {
		this.msgs = msgs;
	}

	public HashMap<String, Client> getUsers() {
		HashMap<String, Client> users = new HashMap<String, Client>();
		for (Message m : msgs) {
			if (!users.containsKey(m.getUser().getLogin()))
				users.put(m.getUser().getLogin(), m.getUser());
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
