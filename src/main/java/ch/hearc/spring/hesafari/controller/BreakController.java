package ch.hearc.spring.hesafari.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.hearc.spring.hesafari.jpa.BreakRepository;
import ch.hearc.spring.hesafari.jpa.UserRepository;
import ch.hearc.spring.hesafari.model.Break;
import ch.hearc.spring.hesafari.model.User;

/**
 * 
 * @author javaee Handles requests for the todo home page
 *
 */
@Controller
public class BreakController {

	// Bean injection
	@Autowired
	private BreakRepository breakRepo;

	@Autowired
	private UserRepository userRepository;

	// Retrieve home.title from application.properties.
	@Value("${home.title:Default title}")
	private String homeTitle;

	@Value("${break.create:Default title}")
	private String breakCreate;

	// **********//
	// MAPPINGS //
	// **********//

	/**
	 * Select the home view to render by returning its name
	 * 
	 * @RequestMapping(value = "/", method = {RequestMethod.GET,
	 *                       RequestMethod.POST})
	 */
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(@RequestParam Optional<String> search, Map<String, Object> model) {

		// Send title retrieved from application.properties
		model.put("title", homeTitle);

		if (search.isEmpty()) {
			// Put the todo list from the DAO
			model.put("breaks", breakRepo.findAll());
			model.put("searched", "");
		} else {
			System.out.println(search);
			model.put("breaks", breakRepo.findAllByLocation(search.get()));
			model.put("searched", search.get());
		}

		// Get current user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			User user = (User) principal;

			List<Long> invalidBreaks = breakRepo.findAll().stream()
					.filter(b -> b.getAttends().stream().filter(u -> u.getUsername().equals(user.getUsername()))
							.findFirst().isPresent() || b.getOwner().getUsername().equals(user.getUsername()))
					.mapToLong(b -> b.getBreakID()).boxed().collect(Collectors.toList());

			model.put("invalid_breaks", invalidBreaks);
		} else {
			model.put("invalid_breaks", Collections.emptyList());
		}
		return "home";
	}

	@GetMapping("/create")
	public String create(Break newBreak) {

		// Send title retrieved from application.properties
//		model.put("title", breakCreate);

		// Return the page "home.html"
		return "create_break";
	}

	@PostMapping("/create")
	public String processCreate(Break newBreak, BindingResult bindingResult, Map<String, Object> model,
			RedirectAttributes redirAttrs) {

		if (bindingResult.hasErrors()) {
			model.put("error", true);
			return "create_break";
		}

		// Get current user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			User user = (User) principal;

			// Set Owner
			newBreak.setOwner(user);

			breakRepo.save(newBreak);

			redirAttrs.addFlashAttribute("breakCreated", true);

			// Return the page "home.html"
			return "redirect:/";
		} else {
			return "redirect:/user/login";
		}
	}

	@GetMapping("/attend")
	public String attendTo(@RequestParam String id, RedirectAttributes redirAttrs) {
		// Find the break
		Optional<Break> b = breakRepo.findById(Long.parseLong(id));

		if (b.isEmpty()) {
			return "redirect:/";
		} else {
			// Get current user
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof User) {
				User user = (User) principal;

				// Add the break to the user
				user.getAttendedBreaks().add(b.get());

				// Increment reputation
				b.get().getOwner().setReputation(b.get().getOwner().getReputation() + 1);

				userRepository.save(user);
				userRepository.save(b.get().getOwner());

				redirAttrs.addFlashAttribute("breakAttended", true);

				return "redirect:/";

			} else {
				return "redirect:/user/login";
			}
		}
	}

	@RequestMapping(value = "/break", method = { RequestMethod.GET, RequestMethod.POST })
	public String breakUsers(Map<String, Object> model, @RequestParam String id) {

		Optional<Break> b = breakRepo.findById(Long.parseLong(id));

		if (b.isEmpty()) {
			return "redirect:/";
		} else {
			model.put("break", b.get());

			// Return the page "break_users.html"
			return "break_users";
		}
	}

}
