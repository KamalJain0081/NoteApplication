package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.NoteRequestDto;
import com.dto.NoteResponseDto;
import com.service.NoteServiceInterface;

@RestController
@RequestMapping("/note")
public class NoteController 
{
	private NoteServiceInterface noteService;
	
	public NoteController(NoteServiceInterface noteService) 
	{
		this.noteService = noteService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createNote(@RequestBody NoteRequestDto RequestDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(noteService.createNote(RequestDto));
		}catch(Exception ex){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong please try createing the note again");
		}
	}

}
