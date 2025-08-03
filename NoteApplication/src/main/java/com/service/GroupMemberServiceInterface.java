package com.service;

import org.springframework.stereotype.Service;

import com.dto.GroupMemberRequestDto;
import com.dto.GroupMemberResponseDto;

@Service
public interface GroupMemberServiceInterface {
	
	GroupMemberResponseDto addGroupMember(GroupMemberRequestDto groupMemberDto);
	String deleteGroupMember(long groupMemberId);
}
