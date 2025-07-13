package com.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "notification_data", columnDefinition = "TEXT")
    private String notificationData;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Users receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Users sender;

    @Column(name = "delivery_status", length = 20, nullable = false)
    private String deliveryStatus = "PENDING";

    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;

    // Constructors
    public Notification() {}

    // Getters and setters
    public Long getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationData() {
        return notificationData;
    }
    public void setNotificationData(String notificationData) {
        this.notificationData = notificationData;
    }

    public Users getReceiver() {
        return receiver;
    }
    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }

    public Users getSender() {
        return sender;
    }
    public void setSender(Users sender) {
        this.sender = sender;
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

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", notificationData=" + notificationData
				+ ", receiver=" + receiver + ", sender=" + sender + ", deliveryStatus=" + deliveryStatus
				+ ", deliveryTime=" + deliveryTime + "]";
	}
    
}
