package com.javainuse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class Parent {

	@GetMapping({ "/search/ali" })
	String getName() {
		System.out.println("ssssssssss");
		return "aaaaaaaaaaaaliiiiiiii";
	}

	@GetMapping({ "/search" })
	String getName1() {
		return "sooooooooooo";
	}

	@GetMapping({ "/add" })
	String getName2() {
		return "dddddoooooooo";
	}

}
