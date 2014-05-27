package servlets;

import java.util.HashMap;

import junit.framework.Assert;

import org.junit.Test;

import beans.Chat;
import beans.Client;

public class TestIsEqual {

	@Test
	public void test() {
		Client c1 = new Client(null, "c1", null, "mina", "shakhloul", 1);
		Client c2 = new Client(null, "c2", null, "leon", "ET", 2);
		Client c3 = new Client(null, "c3", null, "yazid", "Bousetta", 3);
		HashMap<Integer, Client> listToHave = new HashMap<Integer, Client>();
		listToHave.put(c1.getId(), c1);
		listToHave.put(c2.getId(), c2);
		HashMap<Integer, Client> discussion = new HashMap<Integer, Client>();
		Chat o = new Chat("C0");
		o.addFriendToDiscussion(c1);
		o.addFriendToDiscussion(c2);
		discussion = o.getFriendsFromDiscussion();
		Assert.assertEquals(listToHave, discussion);
		listToHave.clear();
		discussion.clear();
		listToHave.put(c1.getId(), c1);
		listToHave.put(c3.getId(), c3);
		Chat o1 = new Chat("C1");
		o1.addFriendToDiscussion(c1);
		o1.addFriendToDiscussion(c3);
		discussion = o1.getFriendsFromDiscussion();
		Assert.assertTrue(isEqualTo(listToHave, discussion));
		listToHave.clear();
		discussion.clear();
		listToHave.put(c2.getId(), c2);
		listToHave.put(c3.getId(), c3);
		Chat o2 = new Chat("C2");
		o2.addFriendToDiscussion(c1);
		o2.addFriendToDiscussion(c2);
		discussion = o2.getFriendsFromDiscussion();
		Assert.assertTrue(isEqualTo(listToHave, discussion));
	}

	private boolean isEqualTo(HashMap<Integer, Client> listOfFriends, HashMap<Integer, Client> friendsFromDiscussion) {
		boolean equal = false;
		if (listOfFriends.size() != friendsFromDiscussion.size())
			return equal;
		else {
			if (listOfFriends.keySet().equals(friendsFromDiscussion.keySet()))
				equal = true;
			/*
			 * for (Integer id : listOfFriends.keySet()) { if
			 * (friendsFromDiscussion.containsKey(id)) equal = true; else equal
			 * = false; }
			 */
		}
		return equal;
	}
}
