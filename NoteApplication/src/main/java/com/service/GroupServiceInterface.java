package com.service;

import org.springframework.stereotype.Service;

import com.entities.Group;

@Service
public interface GroupServiceInterface {
	
	Group findByGroupId(long groupId);
}
