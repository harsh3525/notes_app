package com.gotprint.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotprint.notes.dto.NoteDTO;
import com.gotprint.notes.entity.NoteEntity;
import com.gotprint.notes.mapper.NoteMapper;
import com.gotprint.notes.repository.NoteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteMapper noteMapper;
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public NoteDTO createNote(NoteDTO noteDTO) {
		NoteEntity noteEntity = noteMapper.noteDTOToNoteEntityConverter(noteDTO);
		return noteMapper.noteEntityToNoteDTOConverter(noteRepository.save(noteEntity));
	}

	@Override
	public List<NoteDTO> getAllNotes() {
		return noteRepository.findAll().stream().map(noteEntity -> noteMapper.noteEntityToNoteDTOConverter(noteEntity))
				.toList();
	}

	@Override
	public NoteDTO getSingleNote(Long noteId) {
		NoteEntity noteEntity = noteRepository.findById(noteId)
				.orElseThrow(() -> new EntityNotFoundException("Note not found with id " + noteId));
		return noteMapper.noteEntityToNoteDTOConverter(noteEntity);

	}

	@Override
	public NoteDTO updateNote(Long noteId, NoteDTO noteDTO) {
		NoteEntity savedEntity = noteRepository.findById(noteId)
				.orElseThrow(() -> new EntityNotFoundException("Note not found with id " + noteId));
		savedEntity.setTitle(noteDTO.getNote());
		savedEntity.setNote(noteDTO.getNote());

		return noteMapper.noteEntityToNoteDTOConverter(noteRepository.save(savedEntity));
	}

	@Override
	public void deleteNote(Long noteId) {
		NoteEntity noteEntity = noteRepository.findById(noteId)
				.orElseThrow(() -> new EntityNotFoundException("Note not found with id " + noteId));
		noteRepository.delete(noteEntity);
	}

}
