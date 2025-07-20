package com.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.dto.UserRequestDto;

@Service
public interface UserServiceInterface  {

	Map<String, String> createUser(UserRequestDto userReqDto);
	
	Map<String, String> updateUserData(UserRequestDto userRequestDto);
	
	Map<String, String> getUserProfile(String email);
}
