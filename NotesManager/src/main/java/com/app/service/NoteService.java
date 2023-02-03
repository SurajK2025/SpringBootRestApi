package com.app.service;

import com.app.pojos.Note;

public interface NoteService {
	Note addNewNote(Note transientUser);
	Note fetchNoteDetails(Long userId);
	Note updateNoteDetails(Note detachedNote);
	String deleteNoteDetails(Long noteId);
}
