package com.gotprint.notes.service;

import java.util.List;

import com.gotprint.notes.dto.NoteDTO;

public interface NoteService {

	NoteDTO createNote(NoteDTO noteDTO);

	List<NoteDTO> getAllNotes();

	NoteDTO getSingleNote(Long noteId);

	NoteDTO updateNote(Long noteId, NoteDTO noteDTO);

	void deleteNote(Long noteId);

}
