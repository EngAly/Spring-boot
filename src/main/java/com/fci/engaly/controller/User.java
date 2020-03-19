package com.fci.engaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fci.engaly.services.MemberDetailsService;

@RestController
@RequestMapping("/user")
public class User {

	@Autowired
	MemberDetailsService memberService;

	@RequestMapping(value = { "", "/hello" })
	public String hello(Authentication auth) {
//		You Can Use Either Bottom line with Authentication auth as method parameter
		UserDetails details = (UserDetails) auth.getPrincipal();

//		Or Use Bottom Lines And Remove Authentication auth From Method Signature
//		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
//		UserDetails details = (UserDetails) auth.getPrincipal();

		return "hello " + details.getUsername();
	}
}
