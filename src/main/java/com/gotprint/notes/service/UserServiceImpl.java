package com.gotprint.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotprint.notes.dto.UserDTO;
import com.gotprint.notes.entity.UserEntity;
import com.gotprint.notes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(UserDTO userDTO) {
		UserEntity userEntity = UserEntity.builder().email(userDTO.getEmail()).password(userDTO.getPassword()).build();
		userRepository.save(userEntity);
	}

}
