package net.codejava.booklist;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControl {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<Users> list(){
		return service.listAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> get(@PathVariable Integer id) {
		try {
		Users user = service.get(id);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PostMapping("/users")
	public void add(@RequestBody Users user) {
		service.save(user);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@RequestBody Users user, @PathVariable Integer id){
		try {
			Users exisUsers = service.get(id);
			service.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
	
