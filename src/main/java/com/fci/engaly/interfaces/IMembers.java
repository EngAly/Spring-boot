package com.fci.engaly.interfaces;

import org.springframework.security.core.Authentication;

public interface IMembers {

	public String getAutority(Authentication auth);
}
