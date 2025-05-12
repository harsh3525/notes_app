package com.gotprint.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotprint.notes.dto.NoteDTO;
import com.gotprint.notes.entity.NoteEntity;
import com.gotprint.notes.entity.UserEntity;
import com.gotprint.notes.mapper.NoteMapper;
import com.gotprint.notes.repository.NoteRepository;
import com.gotprint.notes.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteMapper noteMapper;

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public NoteDTO createNote(NoteDTO noteDTO, String userName) {
		UserEntity user = userRepository.findByEmail(userName).get();
		NoteEntity noteEntity = noteMapper.noteDTOToNoteEntityConverter(noteDTO);
		noteEntity.setUser(user);
		return noteMapper.noteEntityToNoteDTOConverter(noteRepository.save(noteEntity));
	}

	@Override
	public List<NoteDTO> getAllNotes(String userName) {
		UserEntity user = userRepository.findByEmail(userName).get();
		return user.getNotes().stream().map(noteEntity -> noteMapper.noteEntityToNoteDTOConverter(noteEntity)).toList();
	}

	@Override
	public NoteDTO getSingleNote(Long noteId, String userName) {
		UserEntity user = userRepository.findByEmail(userName).get();
		NoteEntity noteEntity = noteRepository.findByIdAndUserId(noteId, user.getId())
				.orElseThrow(() -> new EntityNotFoundException(
						"Either note id not valid " + noteId + " or user " + userName + " does not have access"));
		return noteMapper.noteEntityToNoteDTOConverter(noteEntity);

	}

	@Override
	public NoteDTO updateNote(Long noteId, NoteDTO noteDTO, String userName) {
		UserEntity user = userRepository.findByEmail(userName).get();
		NoteEntity savedEntity = noteRepository.findByIdAndUserId(noteId, user.getId())
				.orElseThrow(() -> new EntityNotFoundException(
						"Either note id not valid " + noteId + " or user " + userName + " does not have access"));
		savedEntity.setTitle(noteDTO.getTitle());
		savedEntity.setNote(noteDTO.getNote());

		return noteMapper.noteEntityToNoteDTOConverter(noteRepository.save(savedEntity));
	}

	@Override
	public void deleteNote(Long noteId, String userName) {
		UserEntity user = userRepository.findByEmail(userName).get();
		NoteEntity noteEntity = noteRepository.findByIdAndUserId(noteId, user.getId())
				.orElseThrow(() -> new EntityNotFoundException(
						"Either note id not valid " + noteId + " or user " + userName + " does not have access"));
		noteRepository.delete(noteEntity);
	}

}
