package com.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class NotificationListItemResponseDto {
	
	private String notificationData;
	private String receiverIds;
	private String deliverStatus;
	private LocalDateTime deliverytime; 

	public String getNotificationData() {
		return notificationData;
	}
	public void setNotificationData(String notificationData) {
		this.notificationData = notificationData;
	}
	public LocalDateTime getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(LocalDateTime deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getDeliverStatus() {
		return deliverStatus;
	}
	public void setDeliverStatus(String deliverStatus) {
		this.deliverStatus = deliverStatus;
	}
	public String getReceiverIds() {
		return receiverIds;
	}
	public void setReceiverIds(String receiverIds) {
		this.receiverIds = receiverIds;
	}
	
}
