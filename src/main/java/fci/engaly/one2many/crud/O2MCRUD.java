package fci.engaly.one2many.crud;

import java.util.Iterator;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fci.engaly.one2many.models.Book;
import fci.engaly.one2many.models.Page;
import fci.engaly.one2many.repositories.BookRepository;
import fci.engaly.one2many.repositories.PageRepository;


 public class O2MCRUD {
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	PageRepository pageRepository;

	@Autowired
	EntityManager em;

	/**
	 * insert book data to database and its pages.
	 */
	public void insert() {
		// create a new book
		Book book = new Book("Java 101", "John Doe", "123456");

		// save the book
		bookRepository.save(book);

		// create and save new pages
		pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
		pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
		pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));

	}

	/**
	 * get all books in database and get all child's get book (parent) and get
	 * all its pages
	 */
	public void findAll() {
		Iterable<Book> books = bookRepository.findAll();
		Book book = null;

		// get all books
		for (Iterator<Book> oneBook = books.iterator(); oneBook.hasNext();) {

			book = oneBook.next();
			System.out.println("book is " + book.toString());

			// get book pages'
			for (Iterator<Page> onePage = book.getPages().iterator(); onePage.hasNext();) {
				System.out.println("page is " + onePage.next().toString());
			}
		}

	}

	/**
	 * get specific book with its id, hence will get all pages from child table
	 * 
	 * @param id
	 */
	public void findById(Long id) {
		try {
			// we can use bookRepository.findById(id) but i search to get multi
			// ways
			// for solution

			Book book = em.find(Book.class, id);

			// book data
			System.out.println(book.toString());

			for (Iterator<Page> page = book.getPages().iterator(); page.hasNext();) {
				// book pages data
				System.out.println(page.next().toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
