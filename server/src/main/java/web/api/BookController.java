package web.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.data.BookRepository;
import web.model.Book;

@RestController
@RequestMapping(path = "/book" , produces = "application/json")
@CrossOrigin("*")
public class BookController {
	private BookRepository bookRepo;

	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	@GetMapping
	public Iterable<Book> getAllBook(){
		return bookRepo.findAll();
	}
	@GetMapping("/{id}")
	public Book getBookByID(@PathVariable("id") int id) {
		Optional<Book> b = bookRepo.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		return null;
	}
	@PostMapping()
	public void addBook(@RequestBody Book book) {
		bookRepo.save(book);
	}
	@PutMapping("/{id}")
	public void saveBook(@RequestBody Book book) {
		bookRepo.save(book);
	}
}
