package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>
{

}
