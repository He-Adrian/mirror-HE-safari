package ch.hearc.spring.hesafari.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import ch.hearc.spring.hesafari.jpa.UserRepository;
import ch.hearc.spring.hesafari.model.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Map<String, Object> model) {
		return "login";
	}

	@RequestMapping(value = "/user/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public String signup(Map<String, Object> model) {
		model.put("user", new User());

		return "signup";
	}

	@PostMapping("/user/process_signup")
	public RedirectView processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepository.save(user);

		return new RedirectView("/");
	}

}
