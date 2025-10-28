package com.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpa.dao.UserRepository;
import com.jpa.model.User;

@Service
public class UserPageService {
	
	@Autowired
	UserRepository repository;
	
	public Page<User> getUserByPage(int pageNumber,int size) {
		PageRequest request = PageRequest.of(pageNumber, size);
		Page<User> page = repository.findAll(request);
		return page;
	}
	
	public Page<User> getUserByPageAndSort(int pageNumber,int size) {
		Sort ascending = Sort.by("age").ascending();
		PageRequest request = PageRequest.of(pageNumber, size,ascending);
		Page<User> page = repository.findAll(request);
		return page;
	}

}
