package com.gotprint.notes.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDTO {
	
	private Long id;
	
	@NotBlank(message = "Title should not be null")
	@Size(max = 50, message = "Title of note should not contain more than 50 characters")
	private String title;
	
	@Size(max = 1000, message = "Note should not contain more than 1000 characters")
	private String note;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime modifiedDate;

}
