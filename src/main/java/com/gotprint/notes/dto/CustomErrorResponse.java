package com.gotprint.notes.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomErrorResponse {
	
	private LocalDateTime timestamp;
	
	private List<FieldErrorResponse> fieldErrors;
	
	private String message;
}
