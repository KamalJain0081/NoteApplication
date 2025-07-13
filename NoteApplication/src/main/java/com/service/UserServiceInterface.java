package com.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dto.UserRequestDto;

@Service
public interface UserServiceInterface  {

	Map<String, String> createUser(UserRequestDto userReqDto);
}
