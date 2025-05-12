package com.gotprint.notes.service;

import java.util.List;

import com.gotprint.notes.dto.NoteDTO;

public interface NoteService {

	NoteDTO createNote(NoteDTO noteDTO, String userName);

	List<NoteDTO> getAllNotes(String userName);

	NoteDTO getSingleNote(Long noteId, String userName);

	NoteDTO updateNote(Long noteId, NoteDTO noteDTO, String userName);

	void deleteNote(Long noteId, String userName);

}
