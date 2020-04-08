package com.medsoftware.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsoftware.model.one2many.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

	List<Author> findByAuthorName(final String authorName);

	List<Author> findByCountry(final String country);
 }
