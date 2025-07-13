package com.dto;

import java.time.LocalDateTime;

public class NoteResponseDto {

    private Long noteId;
    private String noteTitle;
    private String content;
    private Boolean notification;
    private Long groupId;
    private String noteColor;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isPublic;

    public Long getNoteId() {
        return noteId;
    }
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
}
