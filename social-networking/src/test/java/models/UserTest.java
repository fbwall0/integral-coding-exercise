package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User testUser;
	
	@Before
	public void setup() {
		testUser = new User(1, "Forrest");
		testUser.addFollow(2);
		Message testMessage = new Message(1, "Test Message");
		testUser.publishMessage(testMessage);
	}
	
	@Test
	public void user_created_stores_user_id() {
		long expected = 1;
		long actual = testUser.getUserId();
		assertEquals(expected, actual);
	}
	
	@Test
	public void user_created_stores_username() {
		String expected = "Forrest";
		String actual = testUser.getUsername();
		assertEquals(expected, actual);
	}
	
	@Test
	public void user_saves_followed_ids() {
		long expected = 2;
		long actual = testUser.getFollowedUserIds().get(0);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void user_can_add_followed_ids() {
		int expected = testUser.getFollowedUserIds().size();
		assertNotNull(expected);
		expected += 1;
		testUser.addFollow(5);
		int actual = testUser.getFollowedUserIds().size();
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void user_can_unfollow_ids() {
		testUser.addFollow(3);
		int expected = testUser.getFollowedUserIds().size();
		assertNotNull(expected);
		expected -= 1;
		testUser.unfollow(3);
		int actual = testUser.getFollowedUserIds().size();
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void user_can_add_messages() {
		int expected = testUser.getMessages().size();
		assertNotNull(expected);
		expected += 1;
		Message testMessage2 = new Message(2, "Test Message 2");
		testUser.publishMessage(testMessage2);
		int actual = testUser.getMessages().size();
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void user_can_delete_messages() {
		Message testMessage3 = new Message(3, "Test Message 3");
		testUser.publishMessage(testMessage3);
		int expected = testUser.getMessages().size();
		assertNotNull(expected);
		expected -= 1;
		testUser.deleteMessage(3);
		int actual = testUser.getMessages().size();
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

}
