package com.medsoftware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsoftware.dao.PersonRepository;
import com.medsoftware.model.Person;

@RestController
public class PersonController {

	@Autowired
	PersonRepository repository;

	@RequestMapping("/personbyname/{name}")
	public List<Person> findByFirstName(@PathVariable("name") String firstName) {
		return repository.findByFirstName(firstName);
	}

}
