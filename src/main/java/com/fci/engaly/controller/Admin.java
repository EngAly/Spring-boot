package com.fci.engaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fci.engaly.services.MemberDetailsService;

@RestController
@RequestMapping("/admin")
public class Admin {

	@Autowired
	MemberDetailsService memberService;

	/**
	 * end point to get admin authorities(roles) we inject Authentication interface
	 * to get user information via it.<br>
	 * 
	 * notes:- <br>
	 * 1) you can use java.security.Principal interface also.<br>
	 * 2) you can use UserDetails d = (UserDetails) auth.getPrincipal();
	 * 
	 * @param auth
	 * @return
	 */
	@RequestMapping(value = { "", "/hello" })
	public String hello(Authentication auth) {
		UserDetails details = (UserDetails) auth.getPrincipal();
		return "admin => " + details.getUsername();
	}
}
