package com.dto;

import java.time.LocalDateTime;

public class NoteRequestDto {
	
	private Long noteId;
    private String noteTitle;
    private String content;
    private Boolean notification;
    private Long groupId;
    private String noteColor;
    private Boolean isPublic;
    private Long userId;
    private Integer[] sharedWith;
    private Integer[] notifyUsers;
    private LocalDateTime notificationAt;
    
    public String getNoteTitle() {
        return noteTitle;
    }
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getNotification() {
        return notification;
    }
    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getNoteColor() {
        return noteColor;
    }
    public void setNoteColor(String noteColor) {
        this.noteColor = noteColor;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
	public Integer[] getSharedWith() {
		return sharedWith;
	}
	public void setSharedWith(Integer[] sharedWith) {
		this.sharedWith = sharedWith;
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
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
}
