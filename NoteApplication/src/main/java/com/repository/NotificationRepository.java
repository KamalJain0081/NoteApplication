package com.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long>{

	@Query(value = "UPDATE notifications SET delivery_status = :status WHERE sender_id = :id", nativeQuery = true)
	int updateNotificationById(@Param("id") long senderId,@Param("status") String status);
	
	@Query(value = """
			select
				max(notification_data) as notificationData,
				max(delivery_status) as deliverStatus,
				max(delivery_time) as deliverytime,
				string_agg(receiver_id :: text, ',') as receiverIds
			from notifications
			where sender_id = :senderId
			group by sender_id,notification_data
			""", nativeQuery = true)
	List<Map<String,Object>> findNotificationBySenderId(@Param("senderId") long senderId);
}
