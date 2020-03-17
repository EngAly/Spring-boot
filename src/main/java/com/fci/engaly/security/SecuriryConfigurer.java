package com.fci.engaly.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

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
//	use @Qualifier to choose only specific one bean from more one bean
	@Qualifier("passwordEncoder1")
//	With the @Autowired annotation we inject our PasswordEncoder bean into the field passwordEncoder.
	PasswordEncoder passwordEncoder;

	@Autowired
	private MyUserDetailsService myuserDetailsService;

	/**
	 * AuthenticationManagerBuilder it used to create new user and link his with its
	 * role<br>
	 * Role => that will has all URLs permissions for this user like <USER | ADMIN>
	 * here we created two users you can create multi-users
	 * 
	 * important note:- Prior to Spring Security 5.0, the default PasswordEncoder
	 * was NoOpPasswordEncoder which required plain text passwords but is insecure.
	 * Spring Security 5.x onwards, the default PasswordEncoder is
	 * DelegatingPasswordEncoder, which requires a Password Storage Format. The
	 * general format for a password is: {id}encodedPassword is an identifier used
	 * to look up which PasswordEncoder should be used. "noop" which uses plain text
	 * NoOpPasswordEncoder "bcrypt" which uses `BCryptPasswordEncoder' <br>
	 * "scrypt" which uses SCryptPasswordEncoder <br>
	 * "pbkdf2" which uses 'Pbkdf2PasswordEncoder' <br>
	 * "sha256" which uses StandardPasswordEncoder <br>
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		add user for testing login and permitted urls
		auth.inMemoryAuthentication().withUser("test").password("{bcrypt}" + passwordEncoder.encode("test"))
				.roles("USER");
		System.out.println(passwordEncoder.encode("test"));
//		add other user for test authenticated requests with no roles
		auth.inMemoryAuthentication().withUser("auth").password("{noop}auth").roles("TEST");

//		here we assign user ALI with two roles 
		auth.inMemoryAuthentication().withUser("ali").password("{noop}ali").roles("USER", "ADMIN");

//		auth.userDetailsService(myuserDetailsService);
	}

	/**
	 * HttpSecurity used to define URLs for each role i.e link permitted URLs with
	 * Role like <USER | ADMIN> note that => /test/** mean that Role can get all
	 * URLs prefixed with /test/****** note that :- <br>
	 * hasAnyRole can has many roles separate with comma <br>
	 * hasRole has only one role<br>
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		 apply the following about all requests
		http.authorizeRequests()

//				 here we permit for any one to access /login URL to can login to APP secure
				.antMatchers("/login").permitAll()

//				permit for ADMIN roles only to access those URLs
				.antMatchers("/admin/**").hasRole("ADMIN")

//				permit for users with roles  <USER,ADMIN> only to access those antMatchers
				.antMatchers("/user/**").hasAnyRole("USER,ADMIN")

//				any user have authentication permitted to go to any URLs except upper URLs
				.anyRequest().authenticated()

//				
				.and().formLogin()

//				
				.and().logout().logoutSuccessUrl("/login").permitAll()

//				
				.and().csrf().disable();
	}

	/**
	 * Here we create the PasswordEncoder bean; the bean is managed by Spring
	 * container.<br>
	 * the @Bean annotation is used to explicitly declare a bean creation.<br>
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder1() {
//		to use password Encoder
		return new BCryptPasswordEncoder();
	}

	@Bean
	public PasswordEncoder passwordEncoder2() {
//		to ignore password Encoder
		return NoOpPasswordEncoder.getInstance();//
	}

}
