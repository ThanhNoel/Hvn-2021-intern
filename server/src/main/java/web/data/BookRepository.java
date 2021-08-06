package web.data;

import org.springframework.data.repository.CrudRepository;

import web.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
