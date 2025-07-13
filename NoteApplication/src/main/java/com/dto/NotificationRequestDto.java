package com.dto;

import java.time.LocalDateTime;

public class NotificationRequestDto {
    private String notificationData;
    private Long receiverId;
    private Long senderId;
    private String deliveryStatus;
    private LocalDateTime deliveryTime;

    public NotificationRequestDto() {}

    public String getNotificationData() {
        return notificationData;
    }
    public void setNotificationData(String notificationData) {
        this.notificationData = notificationData;
    }

    public Long getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getSenderId() {
        return senderId;
    }
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
