package com.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aop.model.User;
import com.aop.service.UserService;

@RestController
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
    
	@PostMapping("/save")
	public User savedUser(@RequestBody User user) {
	return userService.save(user);
	}
	
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable(name = "id") long id) {
		return userService.getUser(id);
	}
}
