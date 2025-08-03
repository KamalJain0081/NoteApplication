package com.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.UserNote;

@Repository
public interface UserNoteRepository extends JpaRepository<UserNote,Long>{

	@Modifying
	@Query(value = """
			delete from user_notes where note_id = :noteId
			""", nativeQuery = true)
	void deleteUserNoteByNoteId(@Param("noteId") long noteId);
	
	@Modifying
	@Query(value = """
			update user_notes set shared_with = cast(:sharedWith as integer[]) where note_id = :noteId
			""", nativeQuery = true)
	int updateSharedListByNoteId(@Param("sharedWith") Integer[] sharedWith, @Param("noteId") long noteId);
	
	@Modifying
	@Query(value = """
			update user_notes 
			set notify_users = cast(:notifyUsers as integer[]),
				notification_at = :notificationAt
			where note_id = :noteId
			""", nativeQuery = true)
	int updateNotifyUsersAndNotificationAtbynoteId(@Param("notifyUsers") Integer[] notifyUsers, @Param("notificationAt") LocalDateTime notificationAt,
												@Param("noteId") Long noteId);
}
