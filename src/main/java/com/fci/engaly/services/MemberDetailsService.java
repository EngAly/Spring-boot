package com.fci.engaly.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.fci.engaly.interfaces.IMembers;

@Service
public class MemberDetailsService implements IMembers {

	/**
	 * this end point for authenticated users so that:- <br>
	 * 1) we can get user name from Authentication interface with auth.getName()<br>
	 * 2) we can getAuthorities (i.e all roles) using Authentication interface<br>
	 */
	@Override
	public String getAutority(Authentication auth) {
		String message = "";
		for (GrantedAuthority authority : auth.getAuthorities()) {
			System.out.println(authority.getAuthority());
			message += "welcome " + auth.getName() + " your autorites " + authority.getAuthority();
		}
		return message;
	}
}
