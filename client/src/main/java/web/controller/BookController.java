package web.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import web.model.Book;

@Controller
@RequestMapping(path = "/book")
public class BookController {
	public RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public String getListBook(Model model) {
		List<Book> list = Arrays.asList(rest.getForObject("http://localhost:8080/book",Book[].class));
		model.addAttribute("list", list);
		return "/book";
	}
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "/addbook";
	}
	@PostMapping("/addbook")
	public String addBookProcess(@RequestParam("title") String title,@RequestParam("author") String author,@RequestParam("category") String category) {
		Book book = new Book(title, author, category);
		rest.postForObject("http://localhost:8080/book", book, Book.class);
		return "redirect:/book";
	}
	@GetMapping("/updatebook/{id}")
	public String updateBook(@PathVariable("id") int id,Model model) {
		Book book = rest.getForObject("http://localhost:8080/book/{id}",Book.class,id);
		model.addAttribute("book", book);
		return "/updatebook";
	}
	@PostMapping("/updatebook/{id}")
	public String updateBookProcess(@RequestParam("id") int id,@RequestParam("title") String title,@RequestParam("author") String author,@RequestParam("category") String category) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setAuthor(author);
		book.setCategory(category);
		rest.put("http://localhost:8080/book/{id}",book , book.getId());
		return "redirect:/book";
	}
}
