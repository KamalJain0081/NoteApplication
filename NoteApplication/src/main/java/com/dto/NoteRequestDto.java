package com.dto;

public class NoteRequestDto {

    private String noteTitle;
    private String content;
    private Boolean notification;
    private Long groupId;
    private String noteColor;
    private Boolean isPublic;

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
}
