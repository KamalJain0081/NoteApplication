package com.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.dto.NoteRequestDto;
import com.dto.NoteResponseDto;
import com.entities.Note;
import com.repository.NoteRepository;

@Service
public class NoteService implements NoteServiceInterface 
{
	private NoteRepository noteRepository;
	private GroupService groupService;
	
	public NoteService(NoteRepository noteRepository, GroupService groupService) 
	{
		this.noteRepository = noteRepository;
		this.groupService = groupService;
	}
	
	public NoteResponseDto createNote(NoteRequestDto requestDto) {
		Note newNote = new Note();
		newNote.setNoteTitle(requestDto.getNoteTitle());
		newNote.setContent(requestDto.getContent());
		newNote.setNotification(requestDto.getNotification());
		newNote.setGroup(groupService.findByGroupId(requestDto.getGroupId()));
		newNote.setNoteColor(requestDto.getNoteColor());
		newNote.setCreatedAt(LocalDateTime.now());
		newNote.setUpdatedAt(LocalDateTime.now());
		newNote.setIsPublic(requestDto.getIsPublic());
		newNote = noteRepository.save(newNote);
		NoteResponseDto responseDto = new NoteResponseDto();
		responseDto.setNoteId(newNote.getNoteId());
		responseDto.setNoteTitle(newNote.getNoteTitle());
		responseDto.setContent(newNote.getContent());
		responseDto.setNotification(newNote.getNotification());
		responseDto.setGroupId(newNote.getGroup().getGroupId());
		responseDto.setNoteColor(newNote.getNoteColor());
		responseDto.setCreatedAt(newNote.getCreatedAt());
		responseDto.setUpdatedAt(newNote.getUpdatedAt());
		responseDto.setIsPublic(newNote.getIsPublic());
		return responseDto;
	}
	
}
