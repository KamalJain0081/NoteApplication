package com.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dto.NotificationListItemResponseDto;
import com.dto.NotificationRequestDto;
import com.dto.NotificationResponseDto;
import com.entities.Notification;
import com.repository.NotificationRepository;
import com.repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotificationService implements NotificationServiceInterface{

	private NotificationRepository notificationRepo;
	private UsersRepository userRepo;
	
	public NotificationService(NotificationRepository notificationRepo, UsersRepository userRepo) {
		this.notificationRepo = notificationRepo;
		this.userRepo = userRepo;
	}
	
	@Override
	public NotificationResponseDto addNotification(NotificationRequestDto notificationRequestDto) {
		Notification notification = new Notification();
		notification.setNotificationData(notificationRequestDto.getNotificationData());
		notification.setSender(userRepo.findById(notificationRequestDto.getSenderId())
				.orElseThrow(() -> new EntityNotFoundException("Sender not found by Id.")));
		notification.setReceiver(userRepo.findById(notificationRequestDto.getReceiverId())
				.orElseThrow(() -> new EntityNotFoundException("Receiver not found by Id.")));
		notification.setDeliveryStatus(notificationRequestDto.getDeliveryStatus());
		notification.setDeliveryTime(notificationRequestDto.getDeliveryTime());
		notification = notificationRepo.save(notification);
		
		NotificationResponseDto responseDto = new NotificationResponseDto();
		responseDto.setNotificationId(notification.getNotificationId());
		responseDto.setNotificationData(notification.getNotificationData());
		responseDto.setSenderId(notification.getSender().getUserId());
		responseDto.setSenderName(notification.getSender().getName());
		responseDto.setReceiverId(notification.getReceiver().getUserId());
		responseDto.setReceiverName(notification.getReceiver().getName());
		responseDto.setDeliveryStatus(notification.getDeliveryStatus());
		responseDto.setDeliveryTime(notification.getDeliveryTime());
		return responseDto;
	}

	@Override
	public String UpdateNotificationStatus(long notificationId, String status) {
		int updatedRows = notificationRepo.updateNotificationById(notificationId, status);
		String message;
		if(updatedRows > 0) {
			message = "notification status updated";
		}else {
			message = "notification status not updated please try again";
		}
		return message;
	}

	@Override
	public List<NotificationListItemResponseDto> getNotificationList(long senderId) {
		List<NotificationListItemResponseDto> response = new ArrayList<>();
		List<Map<String,Object>> notificationList = notificationRepo.findNotificationBySenderId(senderId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for(Map<String,Object> listItem:notificationList) {
			NotificationListItemResponseDto responseitem = new NotificationListItemResponseDto();
			responseitem.setNotificationData(listItem.get("notificationData").toString());
			responseitem.setDeliverStatus(listItem.get("deliverStatus").toString());
			responseitem.setDeliverytime(((Timestamp) listItem.get("deliverytime")).toLocalDateTime());
			responseitem.setReceiverIds(listItem.get("receiverIds").toString());
			response.add(responseitem);
		}
		return response;
	}

}
