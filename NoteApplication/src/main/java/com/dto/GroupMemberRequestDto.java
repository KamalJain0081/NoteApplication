package com.dto;

public class GroupMemberRequestDto {

    private Long groupId;
    private Long userId;
    private Long addedByUserId;
    private String memberColor;

    public GroupMemberRequestDto() {}

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
}
