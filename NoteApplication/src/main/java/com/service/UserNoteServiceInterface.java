package com.service;

import org.springframework.stereotype.Service;

import com.dto.RequestNotifyDataDto;
import com.dto.RequestSharedListDto;

@Service
public interface UserNoteServiceInterface {

	String updateSharedListByNoteId(RequestSharedListDto sharedListDto);
	String updateNotifyUsersandTimeByUserId(RequestNotifyDataDto notifyDataDto);
}
