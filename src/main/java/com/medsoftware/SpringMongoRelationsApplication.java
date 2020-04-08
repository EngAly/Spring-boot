package com.medsoftware;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.medsoftware.dao.AuthorRepository;
import com.medsoftware.dao.BookRepository;
import com.medsoftware.dao.PersonRepository;
import com.medsoftware.model.Address;
import com.medsoftware.model.Person;
import com.medsoftware.model.one2many.Author;
import com.medsoftware.model.one2many.Book;

@SpringBootApplication
public class SpringMongoRelationsApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AuthorRepository authRepo;
	@Autowired
	private BookRepository bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoRelationsApplication.class, args);
	}

	/**
	 * insert nested document<br>
	 * insert group of document inside other document document<br< for instance:-
	 * <br>
	 * insert group of addresses (i.e list of addresses) documents inside person<br>
	 * so that person has list of addresses but there drawback in this way:-<br>
	 * grow in document in single document and mongodb restrict document to 4M
	 * size<br>
	 */
	public void insertDoc() {
		// create group of addresses and inject all to list
		final Address address1 = new Address("Imaginary City", "UK");
		final Address address2 = new Address("good city", "Egypt");
		final Address address3 = new Address("dream parking", "US");

		// inject all addresses to array
		List<Address> addresses = Arrays.asList(address1, address2, address3);

		// create person record with all its addresses
		final Person john = new Person("John", "Doe", addresses);

		// migrate person info to mongodb
		personRepository.save(john);

	}

	/**
	 * insert document reference inside other document<br>
	 * to solve upper mentioned problem we use reference document<br>
	 * the problem is how to store multi book for one author<br>
	 * the way is :-<br>
	 * create author document<br>
	 * create book documents single each alone but each book document has a
	 * reference for author document that has all this books.
	 */
	public void insertReference() {
//		create author record
		final Author author = new Author("mostafa-mahmoud", "egypt");

//		migrate author info to mongodb
		authRepo.save(author);

		// create more book for same author
		final Book book = new Book("dialogue with an atheist", 250, author.getId());
		final Book book1 = new Book("the spider", 150, author.getId());
		final Book book2 = new Book("the devil rules", 90, author.getId());

//		inject all books to list
		List<Book> books = Arrays.asList(book, book1, book2);

		// migrate book list to mongodb
		bookRepo.saveAll(books);

	}

	@Override
	public void run(String... args) throws Exception {
//		insertDoc();
		insertReference();

	}

}
