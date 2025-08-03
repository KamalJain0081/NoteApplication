package com.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CommentRequestDto;
import com.dto.NoteRequestDto;
import com.dto.RequestNotifyDataDto;
import com.dto.RequestSharedListDto;
import com.service.CommentService;
import com.service.NoteServiceInterface;
import com.service.UserNoteService;

@RestController
@RequestMapping("/note")
public class NoteController 
{
	private NoteServiceInterface noteService;
	private UserNoteService userNoteService;
	private CommentService commentService;
	
	public NoteController(NoteServiceInterface noteService, UserNoteService userNoteService, CommentService commentService) 
	{
		this.noteService = noteService;
		this.userNoteService = userNoteService;
		this.commentService = commentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createNote(@RequestBody NoteRequestDto RequestDto) {
		return ResponseEntity.status(HttpStatus.OK).body(noteService.createNote(RequestDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateNote(@RequestBody NoteRequestDto requestDto){
		noteService.updateNote(requestDto);
		return ResponseEntity.status(HttpStatus.OK).body("Your Note has been Updated.");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteNote(@RequestParam("id") Long noteId){
		noteService.deleteNote(noteId);
		return ResponseEntity.status(HttpStatus.OK).body("Your Note has been Deleted.");
	}
	
	@PutMapping("/share")
	public ResponseEntity<String> updateSharedList(@RequestBody RequestSharedListDto sharedListDto){
		return ResponseEntity.status(HttpStatus.OK).body(userNoteService.updateSharedListByNoteId(sharedListDto));
	}
	
	@PutMapping("/notify")
	public ResponseEntity<String> updateNotificationData(@RequestBody RequestNotifyDataDto notifyDto){
		return ResponseEntity.status(HttpStatus.OK).body(userNoteService.updateNotifyUsersandTimeByUserId(notifyDto));
	}
	
	@PostMapping("/comments")
	public ResponseEntity<?> addCommentToNote(@RequestBody CommentRequestDto commentDto){
		return ResponseEntity.status(HttpStatus.OK).body(commentService.addCommentToNote(commentDto));
	}

}
