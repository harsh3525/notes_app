package com.gotprint.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotprint.notes.dto.UserDTO;
import com.gotprint.notes.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<Void> createUser(@Valid @RequestBody UserDTO userDTO)
	{
		userService.createUser(userDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
