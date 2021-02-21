package models;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

	private Message testMessage;
	
	
	@Before
	public void setup() {
		testMessage = new Message(1, "Test message");
	}
	
	@Test
	public void message_created_stores_text() {
		String expected = "Test message";
		String actual = testMessage.getText();
		assertEquals(expected, actual);
	}
	
	@Test
	public void message_created_stores_message_id() {
		long expected = 1;
		long actual = testMessage.getMessageId();
		assertEquals(expected, actual);
	}
	
	@Test
	public void message_created_stores_date() {
		Date actual = testMessage.getTimestamp();
		assertNotNull(actual);
	}
	
}
