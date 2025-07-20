package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.Note;
import com.entities.UserNote;

@Repository
public interface UserNoteRepository extends JpaRepository<UserNote, Long>  
{
	@Query("Select un.note FROM UserNote un Where un.user.userId = :userId")
	Optional<List<Note>> findByUser_UserId(@Param("userId") Long userId); 
}
