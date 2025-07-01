package com.service;


import org.springframework.stereotype.Service;
import com.utilityMethods.SecureCipher;


@Service
public class UserService implements UserServiceInterface 
{

	private final SecureCipher cipher;
	
	public UserService(SecureCipher cipher) 
	{	
		this.cipher = cipher;
	}
	
	
 }
