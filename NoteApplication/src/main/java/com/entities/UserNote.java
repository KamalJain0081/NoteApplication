package com.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "user_notes")
public class UserNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_note_id")
    private Long userNoteId;

    @ManyToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "shared_with", columnDefinition = "integer[]")
    private Integer[] sharedWith;

    @Column(name = "notify_users", columnDefinition = "integer[]")
    private Integer[] notifyUsers;

    @Column(name = "notification_at")
    private LocalDateTime notificationAt;

    public UserNote() {}

    // Getters and Setters

    public Long getUserNoteId() {
        return userNoteId;
    }

    public void setUserNoteId(Long userNoteId) {
        this.userNoteId = userNoteId;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

	@Override
	public String toString() {
		return "UserNote [userNoteId=" + userNoteId + ", note=" + note + ", user=" + user + ", sharedWith="
				+ Arrays.toString(sharedWith) + ", notifyUsers=" + Arrays.toString(notifyUsers) + ", notificationAt="
				+ notificationAt + "]";
	}
  
}
