package com.gotprint.notes.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDTO {
	
	private Long id;
	
	private String title;
	
	private String note;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime modifiedDate;

}
