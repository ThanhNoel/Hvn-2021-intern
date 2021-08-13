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

import web.model.User;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	public RestTemplate rest = new RestTemplate();
	
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
	
}
