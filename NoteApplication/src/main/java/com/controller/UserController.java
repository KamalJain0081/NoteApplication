package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.UserServiceInterface;

@RestController
@RequestMapping("user/")
public class UserController 
{
	private final UserServiceInterface userService;
	
	public UserController(UserServiceInterface userService) 
	{
		this.userService = userService;
	}
	


}
