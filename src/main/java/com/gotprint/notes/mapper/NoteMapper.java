package com.gotprint.notes.mapper;

import org.springframework.stereotype.Component;

import com.gotprint.notes.dto.NoteDTO;
import com.gotprint.notes.entity.NoteEntity;

@Component
public class NoteMapper {
	
	public NoteDTO noteEntityToNoteDTOConverter(NoteEntity noteEntity)
	{
		return NoteDTO.builder()
				.id(noteEntity.getId())
				.title(noteEntity.getTitle())
				.note(noteEntity.getNote())
				.createdDate(noteEntity.getCreatedDate())
				.modifiedDate(noteEntity.getModifiedDate())
				.build();
	}
	
	public NoteEntity noteDTOToNoteEntityConverter(NoteDTO noteDTO)
	{
		return NoteEntity.builder()
				.title(noteDTO.getTitle())
				.note(noteDTO.getNote())
				.build();
	}

}
