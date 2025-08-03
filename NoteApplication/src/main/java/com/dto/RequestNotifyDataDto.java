package com.dto;

import java.time.LocalDateTime;

public class RequestNotifyDataDto {
	
	private Integer[] notifyUsers;
	private LocalDateTime notificationAt;
	private Long noteId;
	
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	public Integer[] getNotifyUsers() {
		return notifyUsers;
	}
	public void setNotifyUsers(Integer[] notifyUsers) {
		this.notifyUsers = notifyUsers;
	}
	public LocalDateTime getNotificationAt() {
		return notificationAt;
	}
	public void setNotificationAt(LocalDateTime notificationAt) {
		this.notificationAt = notificationAt;
	}
	
	
}
