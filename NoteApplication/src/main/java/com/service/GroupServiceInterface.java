package com.service;

import org.springframework.stereotype.Service;

import com.dto.GroupListResponse;
import com.dto.GroupRequestDto;
import com.dto.GroupResponseDto;
import com.entities.Group;

@Service
public interface GroupServiceInterface {
	
	Group findByGroupId(long groupId);
	GroupResponseDto createGroup(GroupRequestDto groupDto);
	GroupListResponse getGroupListByUserId(long userId);
}
