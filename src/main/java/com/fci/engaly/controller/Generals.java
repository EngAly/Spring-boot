package com.fci.engaly.controller;

 import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
@RequestMapping("/public")
public class Generals {

	@RequestMapping()
	public String hello(Authentication auth) {
		return "Hello with everyone";
	}
}
