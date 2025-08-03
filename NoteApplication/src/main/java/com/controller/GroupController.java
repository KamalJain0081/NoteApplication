package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.GroupMemberRequestDto;
import com.dto.GroupRequestDto;
import com.service.GroupMemberService;
import com.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {
	
	private GroupService groupService;
	private GroupMemberService groupMemberService;
	
	public GroupController(GroupService groupService, GroupMemberService groupMemberService){
		this.groupService = groupService;
		this.groupMemberService = groupMemberService;
	}

	@PostMapping("/create")
	public ResponseEntity<?> createGroup(@RequestBody GroupRequestDto groupDto){
		return ResponseEntity.status(HttpStatus.OK).body(groupService.createGroup(groupDto));
	}
	
	@PostMapping("/join")
	public ResponseEntity<?> addGroupMember(@RequestBody GroupMemberRequestDto GroupMemberDto){
		return ResponseEntity.status(HttpStatus.OK).body(groupMemberService.addGroupMember(GroupMemberDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteGroupMember(@PathVariable("id") long memberId){
		return ResponseEntity.status(HttpStatus.OK).body(groupMemberService.deleteGroupMember(memberId));
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<?> getGroupListByUser(@PathVariable("id") long userId){
		return ResponseEntity.status(HttpStatus.OK).body(groupService.getGroupListByUserId(userId));
	}
}
