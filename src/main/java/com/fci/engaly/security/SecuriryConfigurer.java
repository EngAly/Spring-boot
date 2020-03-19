package com.fci.engaly.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import com.fci.engaly.filters.JwtRequestFilter;
import com.fci.engaly.services.MyUserDetailsService;

/**
 * Require the user to be authenticated prior to accessing any URL within our
 * application.<br>
 * Enables HTTP Basic and Form based authentication.<br>
 * Spring Security will automatically render a login page and logout success
 * page for you
 * 
 */
@EnableWebSecurity
public class SecuriryConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	JwtRequestFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		 apply the following about all requests
		http.csrf().disable()//
				.authorizeRequests()
//				  we permit for any one to access /authenticate URL to can login
				.antMatchers("/authenticate").permitAll()
				.antMatchers("/public").permitAll()
				
//				any user have authentication permitted to go to any URLs except upper URLs
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder2() {
//		to ignore password Encoder
		return NoOpPasswordEncoder.getInstance();//
	}

}
