package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>
{	
	Optional<Users> findByEmail(String email);
}
