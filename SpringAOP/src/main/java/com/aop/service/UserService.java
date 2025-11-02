package com.aop.service;

import org.springframework.stereotype.Service;

import com.aop.dao.UserRepository;
import com.aop.exceptions.UserIdNotFoundException;
import com.aop.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {
		User savedUser = userRepository.save(user);
		log.info("Fetched User details : {} ", savedUser);
		return savedUser;
	}

	public User getUser(long id) {
		return userRepository.findById(id)
		     .orElseThrow(() -> new UserIdNotFoundException("No User Found"));
	}
}
