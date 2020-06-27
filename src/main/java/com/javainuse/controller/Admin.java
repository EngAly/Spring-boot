package com.javainuse.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class Admin {

	@GetMapping("/admins")
	String getADmins() {
		return "admins";
	}

	@PostMapping("/newAdmin")
	String addAmins() {
		return "admin is added";
	}
	
	@DeleteMapping("/delAdmin")
	String delAmins() {
		return "admin is deleted";
	}
	
	@PutMapping("/updateAdmin")
	String updateAmins() {
		return "admin is updated";
	}
}
