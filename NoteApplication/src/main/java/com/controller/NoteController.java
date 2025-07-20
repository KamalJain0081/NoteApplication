package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.NoteRequestDto;
import com.service.NoteServiceInterface;
import com.utilityMethods.ResultStatus;

@RestController
@RequestMapping("/note")
public class NoteController 
{
	private NoteServiceInterface noteService;
	
	public NoteController(NoteServiceInterface noteService) 
	{
		this.noteService = noteService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createNote(@RequestBody NoteRequestDto NoteRequestDto, Long userId) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap = noteService.createNote(NoteRequestDto, userId);
		
		if (resultMap.containsKey(ResultStatus.SUCCESS.toString())) {
			System.out.println(resultMap.get(ResultStatus.SUCCESS.toString()));
			return ResponseEntity.status(HttpStatus.CREATED).body(resultMap.get(ResultStatus.SUCCESS.toString()));
		} else {
			System.out.println(resultMap.get(ResultStatus.FAILED.toString()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultMap.get(ResultStatus.FAILED.toString()));
		}
	}
	
	@PostMapping("/getAll")
	public ResponseEntity<String> getAllNotes(Long userId) {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap = noteService.getUserWiseListNotes(userId);
		
		if (resultMap.containsKey(ResultStatus.SUCCESS.toString())) {
			System.out.println(resultMap.get(ResultStatus.SUCCESS.toString()));
			return ResponseEntity.status(HttpStatus.OK).body(resultMap.get(ResultStatus.SUCCESS.toString()));
		} else {
			System.out.println(resultMap.get(ResultStatus.FAILED.toString()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultMap.get(ResultStatus.FAILED.toString()));
		}
	}

}
