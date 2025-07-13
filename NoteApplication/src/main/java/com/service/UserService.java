package com.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Users;
import com.repository.UsersRepository;
import com.utilityMethods.SecureCipher;


@Service
public class UserService implements UserServiceInterface 
{

	@Autowired
	private UsersRepository userRepository;
	
	private final SecureCipher cipher;
	
	public UserService(SecureCipher cipher) 
	{	
		this.cipher = cipher;
	}

 }
