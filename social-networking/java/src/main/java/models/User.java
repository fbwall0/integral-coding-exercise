package models;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private long userId;
	private String username;
	private List<Long> followedUserIds = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();
	
	public User(long userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Long> getFollowedUserIds() {
		return followedUserIds;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void addFollow(long userId) {
		followedUserIds.add(userId);
	}
	
	public void unfollow(long userId) {
		int position = -1;
		for (int i = 0; i < followedUserIds.size(); i++) {
			if (followedUserIds.get(i) == userId) {
				position = i;
			}
		}
		if (position >= 0) {
			followedUserIds.remove(position);
		}
	}
	
	public void publishMessage(Message message) {
		messages.add(message);
	}
	
	public void deleteMessage(long messageId) {
		int position = -1;
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getMessageId() == messageId) {
				position = i;
			}
		}
		if (position >= 0) {
			messages.remove(position);
		}
	}
	
}
