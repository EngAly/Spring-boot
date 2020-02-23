package fci.engaly.one2many.repositories;

import org.springframework.data.repository.CrudRepository;

import fci.engaly.one2many.models.Book;

 
 
public interface BookRepository extends CrudRepository<Book, Long> {
	//fci.engaly.one2many.models.Book findByIsbn(String isbn);
}
