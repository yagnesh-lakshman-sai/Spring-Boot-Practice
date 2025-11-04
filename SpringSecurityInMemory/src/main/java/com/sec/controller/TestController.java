package com.sec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hi") //Securing  ,, user name password correct only works
	public String hi() {
		return "Hii";
	}
	
	@GetMapping("/bye")  //Securing  ,, user name password correct only works
	public String bye() {
		return "Bye";
	}
	
	@GetMapping("/open")  //Open Access to All   ,, No required user name and password
	public String open() {
		return "Open For All";
	}
	
	@GetMapping("/noAccess")  //No Access to Anyone  ,, No Access at all
	public String noAccess() {
		return "NO Access";
	}
}
