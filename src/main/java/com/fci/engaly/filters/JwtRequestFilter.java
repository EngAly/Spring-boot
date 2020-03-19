package com.fci.engaly.filters;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fci.engaly.jwt.JWTUtile;
import com.fci.engaly.services.MyUserDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	JWTUtile jwtUtile;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

//		 get authorizationHeader from request
		final String authorization = request.getHeader("Authorization");

//		define two empty variable
		String token = null, username = null;

//		 if user already send jwt token with bearer
		if (authorization != null && authorization.startsWith("Bearer ")) {
//			extract token from authorization header
			token = authorization.substring(7);
//			send back token to jwtUtile(have all methods that can work with jwt token) to extract username from token stream 
			username = jwtUtile.extractUserName(token);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//			make sure that token in time not expired yet.
			if (jwtUtile.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

 		filterChain.doFilter(request, response);

	}

}
