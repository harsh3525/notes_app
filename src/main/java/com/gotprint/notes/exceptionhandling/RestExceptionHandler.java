package com.gotprint.notes.exceptionhandling;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gotprint.notes.dto.CustomErrorResponse;
import com.gotprint.notes.dto.FieldErrorResponse;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		List<FieldErrorResponse> fieldErros = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> new FieldErrorResponse(error.getField(), error.getDefaultMessage())).toList();
		CustomErrorResponse errorResponse = CustomErrorResponse.builder().timestamp(LocalDateTime.now())
				.fieldErrors(fieldErros).message("Validation Failed").build();

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
		
		CustomErrorResponse errorResponse = CustomErrorResponse.builder().timestamp(LocalDateTime.now())
				.message(ex.getMessage()).build();

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}

}
