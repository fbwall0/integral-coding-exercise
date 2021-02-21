package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Message;
import models.User;

public class Application {
	
	private Map<Long, User> userMap = new HashMap<>(); //map of userIds and user objects
	private long nextUserId = 0; //serialized user ids

	public Application() {
		
	}
	
	public Map<Long, User> getUserMap() {
		return userMap;
	}

	public long getNextUserId() {
		return nextUserId;
	}
	
	public String[] getPersonalTimeline(User user) {
		Message[] messageArray = new Message[user.getMessages().size()];
		messageArray = user.getMessages().toArray(messageArray);
		String[] output = new String[messageArray.length];
		Message swap;
		for (int i = 0; i < messageArray.length - 1; i++) { //sorts output
			for (int j = i + 1; j < messageArray.length; j++) {
				if (getTimeDifference(messageArray[j]) < getTimeDifference(messageArray[i])) {
					swap = messageArray[j];
					messageArray[j] = messageArray[i];
					messageArray[i] = swap;
				}
			}
		}
		for (int i = 0; i < messageArray.length; i++) { //converts output to 
			Message message =  messageArray[i];
			output[i] = "\"" + message.getText() + "\"";
		}
		return output;
	}
	
	public String[] getOthersTimeline(User user) {
		Message[] messageArray = new Message[user.getMessages().size()];
		messageArray = user.getMessages().toArray(messageArray);
		String[] output = new String[messageArray.length];
		Message swap;
		for (int i = 0; i < messageArray.length - 1; i++) { //sorts output
			for (int j = i + 1; j < messageArray.length; j++) {
				if (getTimeDifference(messageArray[j]) < getTimeDifference(messageArray[i])) {
					swap = messageArray[j];
					messageArray[j] = messageArray[i];
					messageArray[i] = swap;
				}
			}
		}
		for (int i = 0; i < messageArray.length; i++) { //converts output to 
			Message message =  messageArray[i];
			output[i] = message.getText() + " (" + getTimeSince(message) + ")";
		}
		return output;
	}
	
	public String[] getFollowedTimeline(User user) {
		List<Message> followedMessages = new ArrayList<>();
		List<Long> users = new ArrayList<>();
		for (Long userId : user.getFollowedUserIds()) {
			List<Message> followedUserMessages = userMap.get(userId).getMessages();
			for (Message message : followedUserMessages) {
				followedMessages.add(message);
				users.add(userId);
			}
		}
		
		Long[] userArray = new Long[users.size()];
		Message[] messageArray = new Message[followedMessages.size()];
		messageArray = user.getMessages().toArray(messageArray);
		String[] output = new String[messageArray.length];
		Long userSwap;
		Message MessageSwap;
		for (int i = 0; i < messageArray.length - 1; i++) { //sorts output
			for (int j = i + 1; j < messageArray.length; j++) {
				if (getTimeDifference(messageArray[j]) < getTimeDifference(messageArray[i])) {
					MessageSwap = messageArray[j];
					messageArray[j] = messageArray[i];
					messageArray[i] = MessageSwap;
					userSwap = userArray[j];
					userArray[j] = userArray[i];
					userArray[i] = userSwap;
				}
			}
		}
		for (int i = 0; i < messageArray.length; i++) {
			Message message =  messageArray[i];
			output[i] = userMap.get(userArray[i]).getUsername() + " - " + message.getText() + " (" + getTimeSince(message) + ")";
		}
		return output;
	}
	
	public User createUser(String username) {
		User newUser = new User(nextUserId, username);
		userMap.put(nextUserId, newUser);
		nextUserId++;
		return newUser;
	}
	
	public long getTimeDifference(Message message) {
		Date currentTime = new Date();
		return currentTime.getTime() - message.getTimestamp().getTime(); // get millisecond difference
	}
	
	
	public String getTimeSince(Message message) {
		Date currentTime = new Date();
		long difference = currentTime.getTime() - message.getTimestamp().getTime(); // get millisecond difference
		difference /= 1000; //convert to seconds
		String unit = " seconds ago";
		if (difference == 1) {
			unit = " second ago";
		}
		if (difference > 60) { // if more than a minute
			difference /= 60;
			if (difference == 1) {
				unit = " minute ago";
			} else {				
				unit = " minutes ago";
			}
			if (difference > 60) { // if more than an hour
				difference /= 60;
				if (difference == 1) {
					unit = " hour ago";
				} else {
					unit = " hours ago";					
				}
				if (difference > 24) { // if more than a day
					difference /= 24;
					if (difference == 1) {
						unit = " day ago";						
					} else {
						unit = " days ago";
					}
				}
			}
		}
		return difference + unit;
		
	}
}
