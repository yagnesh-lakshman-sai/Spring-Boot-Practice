package com.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.model.Courses;

@RestController
public class DBController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/save")
	public String save() {		
		jdbcTemplate.update("insert into courses values(?,?)",11,"ds");
		return "saved HI";
	}
	
	@GetMapping("/get")
	public void getCourses () {
		Courses course = jdbcTemplate.<Courses>queryForObject(
			    "select * from courses where course_id = 1",
			    (rs, rowNum) -> new Courses(rs.getInt("course_id"), rs.getString("course_name"))
			);

	System.out.println(course);
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi Dude!!";
	}
}
