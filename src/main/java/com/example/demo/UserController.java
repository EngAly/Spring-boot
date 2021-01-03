package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users/{id}")
	public User getById(@PathVariable Integer id) {
		return service.getUserById(id);
	}

}
