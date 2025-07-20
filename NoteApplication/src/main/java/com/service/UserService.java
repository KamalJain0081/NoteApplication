package com.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.UserRequestDto;
import com.dto.UserResponseDto;
import com.entities.Users;
import com.repository.UsersRepository;
import com.utilityMethods.ResultStatus;
import com.utilityMethods.SecureCipher;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UsersRepository userRepository;

	private final SecureCipher cipher;

	public UserService(SecureCipher cipher) {
		this.cipher = cipher;
	}

	@Override
	public Map<String, String> createUser(UserRequestDto userReqDto) {

		Map<String, String> map = new HashMap<String, String>();
		Users user = new Users();

		try {
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

			if (userRepository.save(user) != null) {
				map.put(ResultStatus.SUCCESS.toString(), "user inserted successfully");
			} else {
				map.put(ResultStatus.FAILED.toString(), "user insertion failed");
			}
		} catch (Exception e) {
			map.put(ResultStatus.FAILED.toString(), e.getMessage());
		}

		return map;
	}

	@Override
	@Transactional
	public Map<String, String> updateUserData(UserRequestDto userRequestDto) {
		Map<String, String> map = new HashMap<String, String>();
		Users oldUser = userRepository.findByEmail(userRequestDto.getEmail()).get();
		
		if (oldUser == null) {
			map.put(ResultStatus.FAILED.toString(), "user with email : "+ userRequestDto.getEmail() +" not found");
			return map;
		}
//				.orElseThrow(() -> new UsernameNotFoundException("User with Email " + userRequestDto.getEmail() + "Not Found."));;
		oldUser.setName(userRequestDto.getName());
		oldUser.setPassword(userRequestDto.getPassword());
		oldUser.setUpdatedAt(LocalDateTime.now());
		
		if (userRepository.save(oldUser) != null) {
			map.put(ResultStatus.SUCCESS.toString(), "user updated successfully");
		} else {
			map.put(ResultStatus.FAILED.toString(), "user updation failed");
		}
		
		return map;
	}
	
	public Map<String, String> getUserProfile(String email) {
		Map<String, String> map = new HashMap<String, String>();
		UserResponseDto userResponse = new UserResponseDto();
		Users existingUser = userRepository.findByEmail(email).get();
		
		if (existingUser == null) {
			map.put(ResultStatus.FAILED.toString(), "user with email : "+ email +" not found");
			return map;
		}
//				.orElseThrow(() -> new UsernameNotFoundException("User with Email " + email + "Not Found."));
		userResponse.setUserId(existingUser.getUserId());
		userResponse.setName(existingUser.getName());
		userResponse.setEmail(existingUser.getEmail());
		userResponse.setIsActive(existingUser.getIsActive());
		userResponse.setCreatedAt(existingUser.getCreatedAt());;
		userResponse.setUpdatedAt(existingUser.getUpdatedAt());
		
		map.put(ResultStatus.FAILED.toString(), userResponse.toString());
		
		return map;
	}

}
