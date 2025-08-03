package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entities.GroupMember;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long>{

}
