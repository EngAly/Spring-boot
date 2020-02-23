package fci.engaly.one2many.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import fci.engaly.one2many.models.Page;


public interface PageRepository extends CrudRepository<Page, Long> {
//	List<Page> findByBook(fci.engaly.one2many.models.Book book, Sort sort);
}
