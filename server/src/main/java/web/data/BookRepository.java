package web.data;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import web.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{


}
