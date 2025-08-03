package com.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.RequestNotifyDataDto;
import com.dto.RequestSharedListDto;
import com.repository.UserNoteRepository;

@Service
public class UserNoteService implements UserNoteServiceInterface{
	
	private UserNoteRepository userNoteRepository;
	
	public UserNoteService(UserNoteRepository userNoteRepository) {
		this.userNoteRepository = userNoteRepository;
	}

	@Override
	@Transactional
	public String updateSharedListByNoteId(RequestSharedListDto sharedListDto) {
		
		String response;
		if(sharedListDto.getSharedWith().length > 0 && sharedListDto.getNoteId() != 0) {
			int updatedRows = userNoteRepository.updateSharedListByNoteId(sharedListDto.getSharedWith(),sharedListDto.getNoteId());
			if(updatedRows > 0) {
				response = "User Share List has been update.";
			}else {
				return "No rows updated. Possibly invalid noteId.";
			}
		}else {
			response = "Data is not correct";
		}
		return response;
	}
	
	@Transactional
	public String updateNotifyUsersandTimeByUserId(RequestNotifyDataDto notifyDataDto) {
		if (notifyDataDto.getNotifyUsers().length > 0 && notifyDataDto.getNoteId() != 0) {
			int updatedRows = userNoteRepository.updateNotifyUsersAndNotificationAtbynoteId(
				notifyDataDto.getNotifyUsers(),
				notifyDataDto.getNotificationAt(),
				notifyDataDto.getNoteId());
			
			if (updatedRows > 0) {
				return "User Notification List has been updated";
			} else {
				return "No rows updated. Possibly invalid noteId.";
			}
		} else {
			return "Data is not correct";
		}
	}

}
