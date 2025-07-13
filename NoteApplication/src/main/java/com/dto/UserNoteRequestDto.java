package com.dto;

import java.time.LocalDateTime;

public class UserNoteRequestDto {

    private Long noteId;
    private Long userId;
    private Integer[] sharedWith;
    private Integer[] notifyUsers;
    private LocalDateTime notificationAt;

    public UserNoteRequestDto() {}

    public Long getNoteId() {
        return noteId;
    }
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
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
}
