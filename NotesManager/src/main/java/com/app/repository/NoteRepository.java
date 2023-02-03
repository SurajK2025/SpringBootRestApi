package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}