package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.NoteServiceInterface;

@RestController
@RequestMapping("note")
public class NoteRepository 
{
	private NoteServiceInterface noteService;
	
	public NoteRepository(NoteServiceInterface noteService) 
	{
		this.noteService = noteService;
	}
	

}
