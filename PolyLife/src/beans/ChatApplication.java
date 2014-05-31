package beans;

import java.util.HashMap;

public class ChatApplication {

	private HashMap<String, Chat> listOfChats;

	public ChatApplication() {
		setListOfChats(new HashMap<String, Chat>());
	}

	public HashMap<String, Chat> getListOfChats() {
		return listOfChats;
	}

	public void setListOfChats(HashMap<String, Chat> listOfChats) {
		this.listOfChats = listOfChats;
	}
}
