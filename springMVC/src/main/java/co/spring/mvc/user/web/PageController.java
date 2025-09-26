package co.spring.mvc.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String template() throws Exception {
		return "login.page";
	}
	
	@GetMapping("/register")
	public String register() throws Exception {
		return "register.page";
	}
	
	@GetMapping("/main")
	public String main() throws Exception {
		return "main.mainPage";
	}
	
	

}
