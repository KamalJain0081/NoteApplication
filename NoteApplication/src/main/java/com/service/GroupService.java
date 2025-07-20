package com.service;

import org.springframework.stereotype.Service;

import com.entities.Group;
import com.repository.GroupRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GroupService implements GroupServiceInterface{

	private GroupRepository groupRepository;
	
	public GroupService(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}
	
	
	@Override
	public Group findByGroupId(long groupId) {
		return groupRepository.findByGroupId(groupId).orElseThrow(() -> new EntityNotFoundException("Group Not Found."));
	}

}
