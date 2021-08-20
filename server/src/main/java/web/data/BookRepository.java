package web.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import web.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

	@Query(value ="Select b.id,b.author,b.category,b.title from book b,book_user bu where bu.books_id = b.id and bu.user_id = ?1 group by b.id", nativeQuery = true )
	List<Book> findBookByUserId(int user_id);
	
	@Modifying
	@Query(value ="insert into book_user (user_id,books_id) values (?1,?2)", nativeQuery = true)
	@Transactional
	void insertBook(int user_id,int books_id);
	
}
