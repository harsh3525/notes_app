package com.gotprint.notes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotprint.notes.entity.NoteEntity;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
	
	@PostMapping("/createNote")
	public void createNote() {
		//TODO Implementation pending
	}
	
	@GetMapping("/getAllNotes")
	public List<NoteEntity> getAllNotes() {
		//TODO Implementation pending
		return null;
	}
	
	@GetMapping("/{noteId}")
	public NoteEntity getSingleNote(@PathVariable("noteId")Long noteId) {
		return null;
		//TODO Implementation pending
	}
	
	@PutMapping("/updateNote/{noteId}")
	public void updateNote(@PathVariable("noteId")Long noteId) {
		//TODO Implementation pending
	}
	
	@DeleteMapping("/{noteId}")
	public void deleteNote(@PathVariable("noteId")Long noteId) {
		//TODO Implementation pending
	}

}
