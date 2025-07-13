package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> 
{

}
