package com.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.NoteRequestDto;
import com.dto.NoteResponseDto;
import com.entities.Note;
import com.entities.UserNote;
import com.entities.Users;
import com.repository.CommentRepository;
import com.repository.NoteRepository;
import com.repository.UserNoteRepository;
import com.repository.UsersRepository;

@Service
public class NoteService implements NoteServiceInterface
{


    private NoteRepository noteRepository;   
	private GroupService groupService;
	private UsersRepository usersRepository;
	private UserNoteRepository userNoteRepository;
	private CommentRepository commentRepository;
	
	public NoteService(NoteRepository noteRepository, GroupService groupService, UsersRepository usersRepository,
			UserNoteRepository userNoteRepository, CommentRepository commentRepository) 
	{
		this.noteRepository = noteRepository;
		this.groupService = groupService;
		this.usersRepository = usersRepository;
		this.userNoteRepository = userNoteRepository;
		this.commentRepository = commentRepository;
	}
	
	public NoteResponseDto createNote(NoteRequestDto requestDto) {
		
		// Creating a new Note Object
		Note newNote = new Note();
		newNote.setNoteTitle(requestDto.getNoteTitle());
		newNote.setContent(requestDto.getContent());
		newNote.setNotification(requestDto.getNotification());
		newNote.setGroupId(requestDto.getGroupId());
		newNote.setNoteColor(requestDto.getNoteColor());
		newNote.setCreatedAt(LocalDateTime.now());
		newNote.setUpdatedAt(LocalDateTime.now());
		newNote.setIsPublic(requestDto.getIsPublic());
		newNote = noteRepository.save(newNote);
		
		// Making entry of the new note object in the user_note table based on the notification field.
		Users user = usersRepository.findById(requestDto.getUserId())
				.orElseThrow(() -> new RuntimeException("User Not Found, please login again"));
		UserNote newUserNote = new UserNote();
		newUserNote.setNote(newNote);
		newUserNote.setUser(user);
		if(requestDto.getNotification() == true) {
			newUserNote.setSharedWith(requestDto.getSharedWith());
			newUserNote.setNotifyUsers(requestDto.getNotifyUsers());
			newUserNote.setNotificationAt(requestDto.getNotificationAt());
		}else {
			newUserNote.setSharedWith(new Integer[]{0});
			newUserNote.setNotifyUsers(new Integer[]{0});
			newUserNote.setNotificationAt(LocalDateTime.now());
		}
		userNoteRepository.save(newUserNote);
		
		// Creating a NoteResponse Object from the created note.
		NoteResponseDto responseDto = new NoteResponseDto();
		responseDto.setNoteId(newNote.getNoteId());
		responseDto.setNoteTitle(newNote.getNoteTitle());
		responseDto.setContent(newNote.getContent());
		responseDto.setNotification(newNote.getNotification());
		responseDto.setGroupId(newNote.getGroupId());
		responseDto.setNoteColor(newNote.getNoteColor());
		responseDto.setCreatedAt(newNote.getCreatedAt());
		responseDto.setUpdatedAt(newNote.getUpdatedAt());
		responseDto.setIsPublic(newNote.getIsPublic());
		return responseDto;
	}

	@Override
	@Transactional
	public void updateNote(NoteRequestDto requestDto) {
		Note oldNote = noteRepository.findById(requestDto.getNoteId())
				.orElseThrow(() -> new RuntimeException("Note Not Found."));
		oldNote.setNoteTitle(requestDto.getNoteTitle());
		oldNote.setContent(requestDto.getContent());
		oldNote.setNotification(requestDto.getNotification());
		oldNote.setNoteColor(requestDto.getNoteColor());
		oldNote.setUpdatedAt(LocalDateTime.now());
		noteRepository.save(oldNote);
	}

	@Override
	@Transactional
	public void deleteNote(long noteId){
		commentRepository.deleteCommentByNoteId(noteId);
		userNoteRepository.deleteUserNoteByNoteId(noteId);
		noteRepository.deleteById(noteId);
	}
	
}
