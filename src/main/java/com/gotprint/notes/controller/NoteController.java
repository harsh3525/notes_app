package com.gotprint.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotprint.notes.dto.NoteDTO;
import com.gotprint.notes.service.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/createNote")
	public ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO noteDTO) {
		return new ResponseEntity<NoteDTO>(noteService.createNote(noteDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllNotes")
	public ResponseEntity<List<NoteDTO>> getAllNotes() {
		return ResponseEntity.ok(noteService.getAllNotes());
	}
	
	@GetMapping("/{noteId}")
	public ResponseEntity<NoteDTO> getSingleNote(@PathVariable("noteId")Long noteId) {
		return ResponseEntity.ok(noteService.getSingleNote(noteId));
	}
	
	@PutMapping("/updateNote/{noteId}")
	public ResponseEntity<NoteDTO> updateNote(@PathVariable("noteId")Long noteId, @RequestBody NoteDTO noteDTO) {
		return ResponseEntity.ok(noteService.updateNote(noteId, noteDTO));
	}
	
	@DeleteMapping("/{noteId}")
	public ResponseEntity<String> deleteNote(@PathVariable("noteId")Long noteId) {
		noteService.deleteNote(noteId);
		return ResponseEntity.ok("Note is deleted successfully");
	}

}
