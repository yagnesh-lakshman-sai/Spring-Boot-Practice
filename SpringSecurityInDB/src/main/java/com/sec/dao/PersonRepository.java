package com.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Person findByUsername(String username);
}
