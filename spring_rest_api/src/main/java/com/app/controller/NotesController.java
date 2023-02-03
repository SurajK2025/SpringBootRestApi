package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.pojos.Note;
import com.app.service.NoteService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/notes")
public class NotesController {
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/insert")
	public Note saveUserDetails(@RequestBody Note newNote){
		System.out.println("in save emp "+newNote+" id "+newNote.getId());
		return noteService.addNewNote(newNote);	
	}
	
	@GetMapping("/{noteId}")
	public Note getNoteDetails(@PathVariable Long noteId){
		System.out.println("in get emp details "+noteId);
		return noteService.fetchNoteDetails(noteId);
	}
	
	@DeleteMapping("/{noteId}")
	public ApiResponse deleteNote(@PathVariable Long noteId)
	{
		System.out.println("in del emp "+noteId);
		return new ApiResponse(noteService.deleteNoteDetails(noteId));
	}
	
	@PutMapping
	public Note updateNoteDetails(@RequestBody Note detachedNote)
	{
		System.out.println("in update emp "+detachedNote.getId());
		return noteService.updateNoteDetails(detachedNote);
	}
	
}
