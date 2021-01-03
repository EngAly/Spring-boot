package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Cacheable(value = "user", key = "#id", condition = "#id < 10")
	public User getUserById(int id) {
		Optional<User> user = repo.findById(id);
		return user.isPresent() ? user.get() : null;
	}

}
