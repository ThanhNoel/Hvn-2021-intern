package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import web.model.Account;

@Controller
public class AccountController {
	RestTemplate rest = new RestTemplate();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "login";
	}
	@PostMapping("/login")
	public String checkUser(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord,Model model,HttpSession session) {
		String name = rest.getForObject("http://localhost:8080/account/{username}/{password}",String.class,userName,passWord);
		if(name==null) {
			Account account = new Account();
			model.addAttribute("account",account);
			model.addAttribute("failed","Nhập sai tài khoản hoặc mật khẩu");
			return "login";
		}
		else {
			session.setAttribute("name", name);
			return "home";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/home";
	}
}
