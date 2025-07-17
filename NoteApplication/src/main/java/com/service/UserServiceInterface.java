package com.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dto.UserRequestDto;
import com.dto.UserResponseDto;

@Service
public interface UserServiceInterface  {

	Map<String, String> createUser(UserRequestDto userReqDto);
	
	void updateUserData(UserRequestDto userRequestDto);
	
	UserResponseDto getUserProfile(String email);
}
