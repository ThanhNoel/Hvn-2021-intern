package web.controller;

import java.sql.Date;
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
import web.model.Ref;
import web.model.User;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	public RestTemplate rest = new RestTemplate();
	int tmp;
	@GetMapping()
	public String userList(Model model) {
		List<User> list = Arrays.asList(rest.getForObject("http://localhost:8080/user", User[].class));
		model.addAttribute("list",list);
		return "/user";
	}
	@GetMapping("/adduser")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/adduser";
	}
	@PostMapping("/adduser")
	public String addUserProcess(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email,@RequestParam("dob") Date dob) {
		User user = new User(firstName, lastName, email, dob, 0);
		rest.postForObject("http://localhost:8080/user", user, User.class);
		return "redirect:/user";
	}
	
	@GetMapping("/updateuser/{id}")
	public String updateUser(@PathVariable("id") int id,Model model) {
		User user = rest.getForObject("http://localhost:8080/user/{id}", User.class,id);
		model.addAttribute("user",user);
		return "/updateuser";
	}
	@PostMapping("/updateuser/{id}")
	public String updateUserProcess(@RequestParam("id") int id,@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email,@RequestParam("dob") Date dob ) {
		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setDob(dob);
		user.setAge(0);
		rest.put("http://localhost:8080/user/{id}", user, user.getId());
		return "redirect:/user";
	}
	@GetMapping("/listbookuser/{id}")
	public String listBookUser(@PathVariable("id") int user_id, Model model) {
		List<Book> books = Arrays.asList(rest.getForObject("http://localhost:8080/booklist/{user_id}", Book[].class,user_id));
		model.addAttribute("books", books);
		return "/listbookuser";
	}
	@GetMapping("/addbookuser/{id}")
	public String addBookUser(@PathVariable("id") int user_id, Model model) {
		List<Book> books = Arrays.asList(rest.getForObject("http://localhost:8080/book", Book[].class));
		model.addAttribute("books", books);
		tmp = user_id;
		return "/addbookuser";
	}
	@PostMapping("/addbookuser/{id}")
	public String addBookUserProcess(@RequestParam("books_id") String books_id) {
		System.out.println(tmp);
		System.out.println(books_id);
		int tmp2 = Integer.parseInt(books_id);
		Ref ref = new Ref(tmp,tmp2);
		rest.postForObject("http://localhost:8080/booklist", ref , Ref.class);
		return "redirect:/user";
	}
}
