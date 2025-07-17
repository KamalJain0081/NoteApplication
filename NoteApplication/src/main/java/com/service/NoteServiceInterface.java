package com.service;

import org.springframework.stereotype.Service;

import com.dto.NoteRequestDto;
import com.dto.NoteResponseDto;

@Service
public interface NoteServiceInterface {
	
	NoteResponseDto createNote(NoteRequestDto requestDto);
}
