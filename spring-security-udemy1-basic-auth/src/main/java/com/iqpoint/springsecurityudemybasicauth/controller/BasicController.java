package com.iqpoint.springsecurityudemybasicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping("/user/hello")
	public String userHello() {
		return "User says hello";
	}
	
	@GetMapping("/admin/hello")
	public String adminHello() {
		return "admin says hello";
	}
	
	@GetMapping("/poweruser/hello")
	public String powerUserHello() {
		return  "power user says hello";
	}

}
