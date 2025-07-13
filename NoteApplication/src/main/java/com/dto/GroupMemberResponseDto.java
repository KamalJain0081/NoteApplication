package com.dto;

import java.time.LocalDateTime;

public class GroupMemberResponseDto {

    private Long groupMemberId;
    private Long groupId;
    private Long userId;
    private Long addedByUserId;
    private String memberColor;
    private LocalDateTime addedAt;

    public GroupMemberResponseDto() {}

    public Long getGroupMemberId() {
        return groupMemberId;
    }
    public void setGroupMemberId(Long groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddedByUserId() {
        return addedByUserId;
    }
    public void setAddedByUserId(Long addedByUserId) {
        this.addedByUserId = addedByUserId;
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

}
