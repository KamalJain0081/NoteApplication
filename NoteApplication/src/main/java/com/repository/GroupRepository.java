package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long>{
	 
	Optional<Group> findByGroupId(long groupId);
}
