package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserRequestDto;
import com.service.UserServiceInterface;
import com.utilityMethods.ResultStatus;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private UserServiceInterface userService;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody UserRequestDto userReqDto) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap = userService.createUser(userReqDto);

		if (resultMap.containsKey(ResultStatus.SUCCESS.toString())) {
			System.out.println(resultMap.get(ResultStatus.SUCCESS.toString()));
			return ResponseEntity.status(HttpStatus.CREATED).body(resultMap.get(ResultStatus.SUCCESS.toString()));
		} else {
			System.out.println(resultMap.get(ResultStatus.FAILED.toString()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultMap.get(ResultStatus.FAILED.toString()));
		}
	}
}
