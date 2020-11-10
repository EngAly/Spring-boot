package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.singletable.CRUD;

@SpringBootApplication
public class InheritanceApplication implements CommandLineRunner {

	@Autowired
	CRUD crud;

	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		crud.saveAnimal();
		crud.saveHuman();
	}

}
