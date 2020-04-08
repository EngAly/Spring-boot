package com.medsoftware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsoftware.dao.AuthorRepository;
import com.medsoftware.dao.BookRepository;
import com.medsoftware.model.one2many.Author;
import com.medsoftware.model.one2many.Book;

/**
* api to retrive books by author
*/
@RestController
public class BookController {

	@Autowired
	AuthorRepository authorRepo;

	@Autowired
	BookRepository bookRepo;

	@Autowired
	MongoTemplate mongoTemp;

	@RequestMapping("/authorBooks/{authorName}")
	public List<Book> getAuthorBooks(@PathVariable("authorName") String authorName) {
		try {
			Author author = authorRepo.findByAuthorName(authorName).get(0);
			return bookRepo.findByAuthorId(author.getId());
		} catch (Exception e) {
			return null;
		}

//		Query query = new Query();
//		System.out.println(authorName);
//		query.addCriteria(Criteria.where("country").is("egypt"));
//		return (Author) mongoTemp.find(query,Author.class).get(0);

	}
}
