package com.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.dto.GroupListResponse;
import com.dto.GroupRequestDto;
import com.dto.GroupResponseDto;
import com.entities.Group;
import com.repository.GroupRepository;
import com.repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GroupService implements GroupServiceInterface{

	private GroupRepository groupRepository;
	private UsersRepository userRepo;
	
	public GroupService(GroupRepository groupRepository, UsersRepository userRepo) {
		this.groupRepository = groupRepository;
		this.userRepo = userRepo;
	}
	
	
	@Override
	public Group findByGroupId(long groupId) {
		return groupRepository.findByGroupId(groupId).orElseThrow(() -> new EntityNotFoundException("Group Not Found."));
	}


	@Override
	public GroupResponseDto createGroup(GroupRequestDto groupDto) {
		Group group = new Group();
		group.setName(groupDto.getName());
		group.setCreatedBy(userRepo.findById(groupDto.getCreatedByUserId())
				.orElseThrow(() -> new EntityNotFoundException("User not found")));
		group.setCreatedAt(LocalDateTime.now());
		group = groupRepository.save(group);
		
		GroupResponseDto responseDto = new GroupResponseDto();
		responseDto.setGroupId(group.getGroupId());
		responseDto.setName(group.getName());
		responseDto.setCreatedByUserId(group.getCreatedBy().getUserId());
		responseDto.setCreatedAt(group.getCreatedAt());
		return responseDto;
	}


	@Override
	public GroupListResponse getGroupListByUserId(long userId) {
		return groupRepository.findGroupListByUserId(userId);
	}

}
