package com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.NotificationListItemResponseDto;
import com.dto.NotificationRequestDto;
import com.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	private NotificationService notificationService;
	
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@PostMapping("/create")
	ResponseEntity<?> createNotification(@RequestBody NotificationRequestDto notificationRequestDto){
			return ResponseEntity.status(HttpStatus.OK).body(notificationService.addNotification(notificationRequestDto));
	}
	
	@PutMapping("/update/{id}/{status}")
	ResponseEntity<String> updateStatus(@PathVariable("id") long id, @PathVariable("status") String status){
			return ResponseEntity.status(HttpStatus.OK).body(notificationService.UpdateNotificationStatus(id,status));
	}
	
	@GetMapping("/list/{senderId}")
	ResponseEntity<List<NotificationListItemResponseDto>> getNotificationList(@PathVariable("senderId") long senderId){
		return ResponseEntity.status(HttpStatus.OK).body(notificationService.getNotificationList(senderId));
	}
}
