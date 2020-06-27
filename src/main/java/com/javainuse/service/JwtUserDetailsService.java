package com.javainuse.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.javainuse.dao.RoleRepo;
import com.javainuse.dao.UserDao;
import com.javainuse.model.Role;
import com.javainuse.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.javainuse.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			System.out.println("User not found with username");
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
//
//		if (user.getUsername().equals("admin")) {
//			System.out.println("user is admin");
//			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		}

		System.out.println("user.getUsername");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthorities(user.getRoles()));
	}

	/**
	 * register new user to database to can access application resources
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user) {
		System.out.println(user);
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRoles(getRoleRecord(user.getRoles())); // ADMIN, USER and ...
		return userDao.save(newUser);
	}

	/**
	 * give it role without has id yet and return role record from database with
	 * real id so developer can link it with another records in another entities
	 */
	@Autowired
	RoleRepo roleRepo;
	ArrayList<Role> roleRecords;

	private List<Role> getRoleRecord(List<Role> roles) {
		roleRecords = new ArrayList<Role>();
		roles.forEach(role -> {
			roleRecords.add(roleRepo.findByRole(role.getRole()));
		});
		return roleRecords;
	}

	/**
	 * init client authorities add each user role as SimpleGrantedAuthority
	 */
	Set<GrantedAuthority> grantedAuthorities;

	private Set<GrantedAuthority> getAuthorities(List<Role> roles) {
		grantedAuthorities = new HashSet<>();
		roles.forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole())));
		return grantedAuthorities;
	}

}