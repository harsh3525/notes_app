package com.gotprint.notes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gotprint.notes.entity.NoteEntity;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
	
	Optional<NoteEntity> findByIdAndUserId(Long noteId, Long userId);

}
