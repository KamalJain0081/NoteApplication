package com.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.dto.GroupMemberRequestDto;
import com.dto.GroupMemberResponseDto;
import com.entities.GroupMember;
import com.repository.GroupMemberRepository;
import com.repository.GroupRepository;
import com.repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GroupMemberService implements GroupMemberServiceInterface{

	private GroupMemberRepository groupMemberRepo;
	private GroupRepository groupRepo;
	private UsersRepository userRepo;
	
	public GroupMemberService(GroupMemberRepository groupMemberRepo, GroupRepository groupRepo, UsersRepository userRepo){
		this.groupMemberRepo = groupMemberRepo;
		this.groupRepo = groupRepo;
		this.userRepo = userRepo;
	}
	
	@Override
	public GroupMemberResponseDto addGroupMember(GroupMemberRequestDto groupMemberDto) {
		GroupMember newMember = new GroupMember();
		newMember.setGroup(groupRepo.findById(groupMemberDto.getGroupId())
				.orElseThrow(() -> new EntityNotFoundException("Group not found")));
		newMember.setUser(userRepo.findById(groupMemberDto.getUserId())
				.orElseThrow(() -> new EntityNotFoundException("User not found")));
		newMember.setAddedBy(userRepo.findById(groupMemberDto.getAddedByUserId())
				.orElseThrow(() -> new EntityNotFoundException("User not found")));
		newMember.setMemberColor(groupMemberDto.getMemberColor());
		newMember.setAddedAt(LocalDateTime.now());
		newMember = groupMemberRepo.save(newMember);
		
		GroupMemberResponseDto responseDto = new GroupMemberResponseDto();
		responseDto.setGroupMemberId(newMember.getGroupMemberId());
		responseDto.setGroupId(newMember.getGroup().getGroupId());
		responseDto.setUserId(newMember.getUser().getUserId());
		responseDto.setAddedByUserId(newMember.getAddedBy().getUserId());
		responseDto.setMemberColor(newMember.getMemberColor());
		responseDto.setAddedAt(newMember.getAddedAt());
		return responseDto;
	}

	@Override
	public String deleteGroupMember(long groupMemberId) {
		String response;
		if(groupMemberId != 0) {
			groupMemberRepo.deleteById(groupMemberId);
			response = "Member removed Successfully";
		}else {
			response = "invalid id not able to remove member";
		}
		return response;
	}

}
