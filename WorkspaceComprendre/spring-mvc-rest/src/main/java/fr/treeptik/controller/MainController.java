package fr.treeptik.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping(value = {"/login", "/"})
	public String login() {
		Authentication authentication = SecurityContextHolder.getContext()
				 .getAuthentication();
		if(authentication != null) {
			String clientNom = authentication.getName();
			System.out.println(clientNom);
		}
		return "login";
	}
	
}
