//package ch.hearc.spring.hesafari.controller;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.view.RedirectView;
//
//import ch.hearc.spring.hesafari.jpa.BreakRepository;
//import ch.hearc.spring.hesafari.jpa.UserRepository;
//import ch.hearc.spring.hesafari.model.Break;
//import ch.hearc.spring.hesafari.model.User;
//
//@Controller
//public class UserController {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private BreakRepository breakRepo;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
//	public String login(Map<String, Object> model) {
//		return "login";
//	}
//
//	@RequestMapping(value = "/user/signup", method = { RequestMethod.GET, RequestMethod.POST })
//	public String signup(Map<String, Object> model) {
//		model.put("user", new User());
//
//		return "signup";
//	}
//
//	@PostMapping("/user/process_signup")
//	public String processRegister(User user) {
//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//
//		userRepository.save(user);
//
//		return "redirect:/user/login";
//	}
//
//	@GetMapping("/user/owned")
//	public String ownedBreaks(Map<String, Object> model) {
//
//		// Get current user
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof User) {
//			User user = (User) principal;
////
////			List<Break> ownedBreaks = breakRepo.findAll().stream()
////					.filter(b -> b.getOwner().getUsername().equals(user.getUsername())).collect(Collectors.toList());
////
////			ownedBreaks.forEach(b -> System.out.println(b.getOwner().getUsername()));
////
////			model.put("breaks", ownedBreaks);
////
////			if (ownedBreaks.size() == 0) {
////				model.put("noBreak", true);
////			}
//
//			return "owned_breaks";
//
//		} else {
//			return "redirect:/user/login";
//		}
//	}
//
//}
