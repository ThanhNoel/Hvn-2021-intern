package net.codejava.booklist;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookControl {

	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Books> list(){
		return service.listAll();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> get(@PathVariable Integer id) {
		try {
		Books book = service.get(id);
		return new ResponseEntity<Books>(book,HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PostMapping("/books")
	public void add(@RequestBody Books book) {
		service.save(book);
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<?> update(@RequestBody Books book, @PathVariable Integer id){
		try {
			Books existBooks = service.get(id);
			service.save(book);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
	
