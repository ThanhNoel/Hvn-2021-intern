package web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.data.BookRepository;
import web.data.UserRepository;
import web.model.Book;
import web.model.Ref;

@RestController
@RequestMapping(path = "/booklist",produces = "application/json")
public class BookListController {
	@Autowired
	private BookRepository bookRepo;
	public BookListController(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	@GetMapping("/{user_id}")
	public List<Book> getBookByUserID(@PathVariable("user_id") int user_id){
		return bookRepo.findBookByUserId(user_id);
	}
	@PostMapping()
	public void addListBook(@RequestBody Ref ref) {
		System.out.println(ref.toString());
		bookRepo.insertBook(ref.getUser_id(), ref.getBooks_id());
	}
} 
