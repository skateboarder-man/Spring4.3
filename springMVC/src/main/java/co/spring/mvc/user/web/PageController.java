package co.spring.mvc.user.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
	
	@GetMapping("/")
	public String template(Authentication authentication) throws Exception {
		
		if (authentication != null && authentication.isAuthenticated() && 
	            !authentication.getPrincipal().equals("anonymousUser")) {
			  // ⭐ 메인 페이지로 리다이렉션 ⭐
            return "redirect:/main"; 
		}

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
