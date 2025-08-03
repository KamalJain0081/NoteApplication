package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserRequestDto;
import com.service.UserServiceInterface;
import com.utilityMethods.ResultStatus;

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
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap = userService.updateUserData(userRequestDto);
		
		if (resultMap.containsKey(ResultStatus.SUCCESS.toString())) {
			System.out.println(resultMap.get(ResultStatus.SUCCESS.toString()));
			return ResponseEntity.status(HttpStatus.OK).body(resultMap.get(ResultStatus.SUCCESS.toString()));
		} else {
			System.out.println(resultMap.get(ResultStatus.FAILED.toString()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultMap.get(ResultStatus.FAILED.toString()));
		}
	}
	
	@GetMapping("/profile/{email}")
	public ResponseEntity<?> getUserProfile(@RequestParam("email") String email){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.getUserProfile(email));
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}


}
