package com.gotprint.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gotprint.notes.entity.UserEntity;
import com.gotprint.notes.repository.UserRepository;

@Component
public class UsersInitialization {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			UserEntity userEntity = UserEntity.builder().email("test@gmail.com")
					.password(passwordEncoder.encode("password")).build();
			UserEntity userEntity1 = UserEntity.builder().email("test1@gmail.com")
					.password(passwordEncoder.encode("password")).build();
			userRepository.save(userEntity);
			userRepository.save(userEntity1);
		};

	}

}
