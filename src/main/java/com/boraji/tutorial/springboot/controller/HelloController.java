package com.boraji.tutorial.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/hello")
	public String sayHello(Model model) {
		return "hello";
	}
	
	@PostMapping("/hello")
	public String sayHello(@RequestParam String name,Model model) {
		model.addAttribute("name",name);
		return "hello";
	}
}
