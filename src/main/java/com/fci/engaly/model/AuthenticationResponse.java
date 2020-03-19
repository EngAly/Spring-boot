package com.fci.engaly.model;

public class AuthenticationResponse {

	private String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}
