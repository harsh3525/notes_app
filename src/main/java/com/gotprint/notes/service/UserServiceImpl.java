package com.gotprint.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gotprint.notes.dto.UserDTO;
import com.gotprint.notes.entity.UserEntity;
import com.gotprint.notes.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void createUser(UserDTO userDTO) {
		UserEntity userEntity = UserEntity.builder().email(userDTO.getEmail()).password(passwordEncoder.encode(userDTO.getPassword())).build();
		userRepository.save(userEntity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username)
				.orElseThrow(() -> new EntityNotFoundException("User is not registered"));
	}

}
