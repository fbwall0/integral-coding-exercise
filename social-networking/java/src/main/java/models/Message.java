package models;

import java.util.Date;

public class Message {

	private String text;
	private Date timestamp;
	private long messageId;
	
	
	public Message(long messageId, String text) {
		this.messageId = messageId;
		this.text = text;
		this.timestamp = new Date();
	}


	public long getMessageId() {
		return messageId;
	}


	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
//	public String getTimeSince() {
//		Date currentTime = new Date();
//		long difference = currentTime.getTime() - timestamp.getTime(); // get millisecond difference
//		difference /= 1000; //convert to seconds
//		String unit = " seconds ago";
//		if (difference == 1) {
//			unit = " second ago";
//		}
//		if (difference > 60) { // if more than a minute
//			difference /= 60;
//			if (difference == 1) {
//				unit = " minute ago";
//			} else {				
//				unit = " minutes ago";
//			}
//			if (difference > 60) { // if more than an hour
//				difference /= 60;
//				if (difference == 1) {
//					unit = " hour ago";
//				} else {
//					unit = " hours ago";					
//				}
//				if (difference > 24) { // if more than a day
//					difference /= 24;
//					if (difference == 1) {
//						unit = " day ago";						
//					} else {
//						unit = " days ago";
//					}
//				}
//			}
//		}
//		return difference + unit;
//		
//	}
	
	
	
}
