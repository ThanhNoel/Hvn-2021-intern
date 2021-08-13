package web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.data.UserRepository;
import web.model.User;

@RestController
@RequestMapping(path = "/user",produces = "application/json")
@CrossOrigin("*")
public class UserController {
	private UserRepository userRepo;
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	@GetMapping
	public Iterable<User> getAllUser(){
		return userRepo.findAll();
	}
	@GetMapping("/{id}")
	public User getUserByID(@PathVariable("id") int id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		return null;
	}
	@PostMapping
	public void addUser(@RequestBody User user) {
		userRepo.save(user);
	}
	
	@PutMapping("/{id}")
	public void updateUser(@RequestBody User user) {
		userRepo.save(user);
	}

}
