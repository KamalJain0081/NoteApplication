package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.NoteRequestDto;
import com.entities.Note;
import com.entities.UserNote;
import com.entities.Users;
import com.repository.NoteRepository;
import com.repository.UserNoteRepository;
import com.repository.UsersRepository;
import com.utilityMethods.ResultStatus;

@Service
public class NoteService implements NoteServiceInterface 
{

    private final UsersRepository usersRepository;
    private final UserNoteRepository userNoteRepository;
    private NoteRepository noteRepository;
   
	private GroupService groupService;
	
	public NoteService(NoteRepository noteRepository, GroupService groupService,
			UsersRepository usersRepository, UserNoteRepository userNoteRepository) 
	{
		this.noteRepository = noteRepository;
		this.groupService = groupService;
		this.usersRepository = usersRepository;
		this.userNoteRepository = userNoteRepository;
	}
	
	@Transactional
	public Map<String, String> createNote(NoteRequestDto noteRequestDto, Long userId) {
		Map<String, String> map = new HashMap<String, String>();
	
		Users user = usersRepository.findById(userId).get();	
		if(user == null)
		{
			map.put(ResultStatus.FAILED.toString(), "user with user_id : " + userId + " does not exist");
			return map;
		}
		
		Note newNote = new Note();
		newNote.setNoteTitle(noteRequestDto.getNoteTitle());
		newNote.setContent(noteRequestDto.getContent());
		newNote.setNotification(noteRequestDto.getNotification());
		newNote.setIsPublic(noteRequestDto.getIsPublic());
		
		if(noteRequestDto.getIsPublic().equals(true))
		{
			if(!noteRequestDto.getGroupId().equals(0))
			{				
				newNote.setGroup(groupService.findByGroupId(noteRequestDto.getGroupId()));			
			}
		}
		
		newNote.setNoteColor(noteRequestDto.getNoteColor());
		newNote.setCreatedAt(LocalDateTime.now());
		newNote.setUpdatedAt(LocalDateTime.now());
		
		if (noteRepository.save(newNote) != null) 
		{
			UserNote userNote = new UserNote();
			userNote.setNote(newNote);
			userNote.setUser(user);
			
			if(userNoteRepository.save(userNote) != null)
			{				
				map.put(ResultStatus.SUCCESS.toString(), "note created successfully");
			}else
			{
				map.put(ResultStatus.FAILED.toString(), "note creation failed");				
			}
			
		} else {
			map.put(ResultStatus.FAILED.toString(), "note creation failed");
		}
		
//		NoteResponseDto responseDto = new NoteResponseDto();
//		responseDto.setNoteId(newNote.getNoteId());
//		responseDto.setNoteTitle(newNote.getNoteTitle());
//		responseDto.setContent(newNote.getContent());
//		responseDto.setNotification(newNote.getNotification());
//		responseDto.setGroupId(newNote.getGroup().getGroupId());
//		responseDto.setNoteColor(newNote.getNoteColor());
//		responseDto.setCreatedAt(newNote.getCreatedAt());
//		responseDto.setUpdatedAt(newNote.getUpdatedAt());
//		responseDto.setIsPublic(newNote.getIsPublic());
		return map;
	}
	
	public Map<String, String> getUserWiseListNotes(Long userId)
	{ 
		Map<String, String> map = new HashMap<String, String>();
		
		if(!usersRepository.existsById(userId))
		{
			map.put(ResultStatus.FAILED.toString(), "user not exist with user_id : " + userId);
			return map;
		}
		
		List<Note> notesList = new ArrayList<>();
		notesList = userNoteRepository.findByUser_UserId(userId).get();
		
		if(notesList != null)
		{
			List<String> notes = new ArrayList<String>();
			for(Note note : notesList)
			{
				notes.add(note.toString());
			}	
			map.put(ResultStatus.SUCCESS.toString(), notes.toString());
			
		}else
		{
			map.put(ResultStatus.FAILED.toString(), "No notes with user_id : " + userId);
		}
		
		return map;
	}
	
}
