package ch.hearc.spring.todo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(Map<String, Object> model) {
		return "login";
	}

	@RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
	public String signup(Map<String, Object> model) {
		return "signup";
	}
	
}
