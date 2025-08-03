package com.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.entities.Comment;
import com.entities.Note;
import com.dto.CommentRequestDto;
import com.dto.CommentResponseDto;
import com.repository.CommentRepository;
import com.repository.NoteRepository;
import com.repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentService implements CommentServiceInterface {
	
	private CommentRepository commentRepo;
	private NoteRepository noteRepo;
	private UsersRepository userRepo;
	
	public CommentService(CommentRepository commentRepo, NoteRepository noteRepo, UsersRepository userRepo) {
		this.commentRepo = commentRepo;
		this.noteRepo = noteRepo;
		this.userRepo = userRepo;
	}

	@Override
	public CommentResponseDto addCommentToNote(CommentRequestDto commentDto) {
		Comment comment = new Comment();
		comment.setNote(noteRepo.findById(commentDto.getNoteId())
				.orElseThrow(() -> new EntityNotFoundException("Note not found")));
		comment.setUser(userRepo.findById(commentDto.getUserId())
				.orElseThrow(() -> new EntityNotFoundException("User not found")));
		comment.setContent(commentDto.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		comment.setUpdatedAt(LocalDateTime.now());
		commentRepo.save(comment);
		
		CommentResponseDto commentResponse = new CommentResponseDto();
		commentResponse.setCommentId(comment.getCommentId());
		commentResponse.setNoteId(comment.getNote().getNoteId());
		commentResponse.setContent(comment.getContent());
		commentResponse.setUserId(comment.getUser().getUserId());
		commentResponse.setUserName(comment.getUser().getName());
		commentResponse.setCreatedAt(comment.getCreatedAt());
		commentResponse.setUpdatedAt(comment.getUpdatedAt());
		return commentResponse;
	}

}
