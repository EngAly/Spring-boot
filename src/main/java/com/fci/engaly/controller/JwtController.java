package com.fci.engaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fci.engaly.jwt.JWTUtile;
import com.fci.engaly.model.AuthenticationRequest;
import com.fci.engaly.model.AuthenticationResponse;
import com.fci.engaly.services.MyUserDetailsService;


@RestController
public class JwtController {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	MyUserDetailsService userDetailsServ;

	@Autowired
	JWTUtile jwtUtile;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReq) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username and Password");
		}
//		username the username identifying the user whose data is required.
//		will comes back with a fully populated user record (never null)
		final UserDetails userDetails = userDetailsServ.loadUserByUsername(authReq.getUsername());
		final String token = jwtUtile.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));

	}

}
