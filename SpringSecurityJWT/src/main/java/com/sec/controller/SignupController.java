package com.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sec.dao.PersonRepository;
import com.sec.model.Person;

@RestController
public class SignupController {
	
	@Autowired
	PersonRepository personRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/signup")
	public Person signup(@RequestBody Person person) {
		String encodedpassword = passwordEncoder.encode(person.getPassword());
		person.setPassword(encodedpassword);
		
		 return personRepository.save(person);
	}
}
