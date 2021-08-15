package net.codejava.booklist;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<Books> listAll(){
		return repo.findAll();
	}
	public void save(Books book) {
		repo.save(book);
	}
	public Books get(Integer id) {
		return repo.findById(id).get();
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
