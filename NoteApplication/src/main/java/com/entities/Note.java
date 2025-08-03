package com.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "note_title", length = 255)
    private String noteTitle;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "notification", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean notification = false;

    @Column(name = "group_id")
    private Long group_id;

    @Column(name = "note_color", length = 50)
    private String noteColor;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "is_Public", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isPublic = false;

    // Constructors
    public Note() {}

    // Getters and setters

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
        return group_id;
    }
    public void setGroupId(Long group_id) {
        this.group_id = group_id;
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

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", content=" + content + ", notification="
				+ notification + ", group=" + group_id + ", noteColor=" + noteColor + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", isPublic=" + isPublic + "]";
	}
    
}
