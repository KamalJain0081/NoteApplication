package com.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_members")
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_member_id")
    private Long groupMemberId;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "added_by", nullable = false)
    private Users addedBy;

    @Column(name = "member_color", length = 50)
    private String memberColor;

    @Column(name = "added_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime addedAt;

    // Constructors
    public GroupMember() {}

    // Getters and setters
    public Long getGroupMemberId() {
        return groupMemberId;
    }
    public void setGroupMemberId(Long groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }

    public Users getAddedBy() {
        return addedBy;
    }
    public void setAddedBy(Users addedBy) {
        this.addedBy = addedBy;
    }

    public String getMemberColor() {
        return memberColor;
    }
    public void setMemberColor(String memberColor) {
        this.memberColor = memberColor;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }
    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

	@Override
	public String toString() {
		return "GroupMember [groupMemberId=" + groupMemberId + ", group=" + group + ", user=" + user + ", addedBy="
				+ addedBy + ", memberColor=" + memberColor + ", addedAt=" + addedAt + "]";
	}
   
}
