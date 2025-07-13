package com.service;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserRequestDto;
import com.entities.Users;
import com.repository.UsersRepository;
import com.utilityMethods.ResultStatus;
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

	@Override
	public Map<String, String> createUser(UserRequestDto userReqDto) {
	
		Map<String, String> map = new HashMap<String, String>();
        Users user = new Users();
      
	    try
	    {
	    	user.setName(userReqDto.getName());
	    	user.setEmail(userReqDto.getEmail());
	    	
	    	// set encrypt password
	    	user.setPassword(cipher.encrypt(userReqDto.getPassword()));
	    	user.setIsActive(userReqDto.getIsActive());
	    	
	    	if (userReqDto.getIsActive() == null) {
	    		user.setIsActive(true);
	    	}
	    	
	    	// set user creation time 
	    	user.setCreatedAt(LocalDateTime.now());
	    	user.setUpdatedAt(LocalDateTime.now());
	    	
	    	Users insertedUser = userRepository.save(user);	
	    	
	    	if(insertedUser != null)
		    {
		    	map.put(ResultStatus.SUCCESS.toString(), "user inserted successfully");
		    }else
		    {
		    	map.put(ResultStatus.FAILED.toString(), "user insertion failed");
		    }
	    }
	    catch(Exception e)
	    {
	    	map.put(ResultStatus.FAILED.toString(), e.getMessage());
	    }
	    
	    return map;
	}
 }
