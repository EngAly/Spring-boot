package com.javainuse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javainuse.dao.RoleRepo;
import com.javainuse.model.Role;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {

	@Autowired
	RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Role admin = new Role("ROLE_ADMIN");
			Role user = new Role("ROLE_USER");
			roleRepo.saveAll(Arrays.asList(admin, user));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}