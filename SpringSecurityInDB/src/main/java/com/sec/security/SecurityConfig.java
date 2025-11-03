package com.sec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Throwable     {
		return http
		        .csrf(csrf -> csrf.disable())  //csrf disabled
				.authorizeHttpRequests(authorize ->
		                        authorize
		                        .requestMatchers("/login").authenticated()
		                        .requestMatchers("/signup").permitAll()	)	                     
		     .formLogin(Customizer.withDefaults())
		     .httpBasic(Customizer.withDefaults())
		     .build();
	}
}
