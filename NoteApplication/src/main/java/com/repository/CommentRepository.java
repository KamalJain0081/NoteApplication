package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Modifying
	@Query(value = """
			delete from comments where note_id = :noteId
			""", nativeQuery = true)
	void deleteCommentByNoteId(@Param("noteId") long noteId);
}
