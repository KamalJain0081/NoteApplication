package com.service;

import org.springframework.stereotype.Service;

import com.repository.NoteRepository;

@Service
public class NoteService implements NoteServiceInterface 
{
	private NoteRepository noteRepository;
	
	public NoteService(NoteRepository noteRepository) 
	{
		this.noteRepository = noteRepository;
	}
	
}
