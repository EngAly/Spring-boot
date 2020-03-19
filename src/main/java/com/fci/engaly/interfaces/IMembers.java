package com.fci.engaly.interfaces;

import org.springframework.security.core.Authentication;

public interface IMembers {

	/**
	 * API for consuming in service that return all user authorities
	 * 
	 * @param auth
	 * @return
	 */
	public String getAutority(Authentication auth);
}
