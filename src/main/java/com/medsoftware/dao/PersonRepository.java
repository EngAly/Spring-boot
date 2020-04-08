package com.medsoftware.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.medsoftware.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	
	List<Person> findByFirstName(final String firstName);
}
