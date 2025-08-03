package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.GroupListResponse;
import com.entities.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long>{
	 
	Optional<Group> findByGroupId(long groupId);
	
	@Query(value = """
			select group_id as groupId,name from groups
			where group_id in (
			select group_id from group_members where user_id = 1);
			""", nativeQuery = true)
	GroupListResponse findGroupListByUserId(long userId);
}
