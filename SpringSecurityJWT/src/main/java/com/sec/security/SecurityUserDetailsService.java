package com.sec.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sec.dao.PersonRepository;
import com.sec.model.Authority;
import com.sec.model.Person;

public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepository.findByEmail(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		List<Authority> authoritiesFromDB = person.getAuthorities();
		for(Authority authority : authoritiesFromDB) {
		authorities.add(new SimpleGrantedAuthority(authority.getRole()));		
		}
		return User
				.builder()
				.username(person.getEmail())
				.password(person.getPassword())
				.authorities(authorities)
				.build();
	}

}
