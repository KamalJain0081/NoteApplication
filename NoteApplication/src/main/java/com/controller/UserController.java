package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserRequestDto;
import com.dto.UserResponseDto;
import com.service.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController 
{
	private final UserServiceInterface userService;
	
	public UserController(UserServiceInterface userService) 
	{
		this.userService = userService;
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> userUpdate(@RequestBody UserRequestDto userRequestDto){
		try {
			userService.updateUserData(userRequestDto);
			return ResponseEntity.status(HttpStatus.OK).body("User Data Updated");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@GetMapping("/profile")
	public ResponseEntity<?> getUserProfile(String email){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.getUserProfile(email));
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}


}
