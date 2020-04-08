package com.medsoftware.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.medsoftware.model.Person;
import com.medsoftware.model.one2many.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
	
	List<Book> findByAuthorId(final String authorId);
}
