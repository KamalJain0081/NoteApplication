package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.NotificationListItemResponseDto;
import com.dto.NotificationRequestDto;
import com.dto.NotificationResponseDto;

@Service
public interface NotificationServiceInterface {

	NotificationResponseDto addNotification(NotificationRequestDto notificationRequestDto);
	String UpdateNotificationStatus(long notificationId, String status);
	List<NotificationListItemResponseDto> getNotificationList(long senderId);
}
