package com.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.dto.NoteRequestDto;

@Service
public interface NoteServiceInterface {
	
	Map<String, String> createNote(NoteRequestDto requestDto, Long userId);
	Map<String, String> getUserWiseListNotes(Long userId);
}
