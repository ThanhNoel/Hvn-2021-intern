package web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.data.AccountRepository;
import web.data.UserRepository;
import web.model.Account;

@RestController
@RequestMapping(path = "/account",produces = "application/json")
public class AccountController {
	@Autowired
	public AccountRepository accountRepo;
	@Autowired
	public UserRepository userRepo;
	public AccountController(AccountRepository accountRepo,UserRepository userRepo) {
		super();
		this.accountRepo = accountRepo;
		this.userRepo = userRepo;
	}
	@GetMapping
	public Iterable<Account> getAllAccount(){
		return accountRepo.findAll();
	}
	@GetMapping("/{username}/{password}")
	public String getName(@PathVariable("username") String userName,@PathVariable("password") String passWord) {
		Account account = accountRepo.getAccountByUserName(userName);
		if(account == null) return null;
		if(account.getPassword().equals(passWord)) {
			return account.getUserName();
		}
		return null;
	}
}
