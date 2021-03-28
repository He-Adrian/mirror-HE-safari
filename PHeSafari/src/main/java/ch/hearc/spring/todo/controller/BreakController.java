package ch.hearc.spring.todo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import ch.hearc.spring.todo.data.BreakDAO;
import ch.hearc.spring.todo.model.Break;
import ch.hearc.spring.todo.model.Todo;

/**
 * 
 * @author javaee Handles requests for the todo home page
 *
 */
@Controller
public class BreakController {
	
	// Bean injection
	@Autowired
	BreakDAO breakDAO;

	// Retrieve home.title from application.properties.
	@Value("${home.title:Default title}")
	private String homeTitle;

	
	
	//**********//
	// MAPPINGS //
	//**********//
	
	/**
	 * Select the home view to render by returning its name
	 * @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	 */
	@GetMapping("/")
	public String home(Map<String, Object> model) {
		
		// Send title retrieved from application.properties
		model.put("title", homeTitle);

		// Put the todo list from the DAO
		model.put("breaks", breakDAO.getAllbreaks());
		for(Break b:breakDAO.getAllbreaks())
		{
			System.out.println(b.getLocation());
		}
		

		// Return the page "home.html"
		return "home";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(Map<String, Object> model) {
		return "login";
	}
	
	
	/**
	 * Return the page that display todo for the selected date
	 * @param strDate
	 * @param model
	 * @return
	 */
//	@GetMapping("/todoByDate")
//	public String todoByDate(@RequestParam(value = "selectedDate", required = false) String strDate, Map<String, Object> model) {
//		
//		model.put("title", homeTitle);
//
//		// Put the todo list by the given date
//		Date date;
//		try 
//		{
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
//		
//			model.put("todos", todo.getAllTodosByDate(date));
//			model.put("date", date);
//			model.put("totalTime", todo.getTotalTime(date));
//			
//		} catch (ParseException e) {
//			throw new RuntimeException("Error during the parse of the date");
//		}
//
//		// Return the page "home.html"
//		return "todoByDate";
//	}
	

	/**
	 * Function called when a user wants to add a new todo
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public String form(Map<String, Object> model) {
		
		// Put a new Todo (with no data)
		model.put("todo", new Todo());

		// Return the page "formulaire.html"
		return "formulaire";
	}

	
	/**
	 * Save a new todo
	 * 
	 * @param todo
	 * @param errors
	 * @param model
	 * @return
	 */
//	@PostMapping("/Todo")
//	public String saveTodo(@Validated @ModelAttribute Todo todo, BindingResult errors, Model model, RedirectAttributes redirAttrs) {
//		
//		if (!errors.hasErrors()) {
//			if(this.todo.saveTodo(todo))
//			{
//				//If the todo has been correctly saved
//				return ((errors.hasErrors()) ? "todo" : "redirect:/");
//			}
//			else
//			{
//				throw new RuntimeException("The task is not complete ! Please fill all the fields");
//			}
//		}
//		return ((errors.hasErrors()) ? "todo" : "redirect:/");
//	}

	/**
	 * Check/Uncheck the todo
	 * 
	 * @param todo
	 * @param errors
	 * @param model
	 * @return
	 */
//	@PostMapping("/Check")
//	public String checkTodo(@Validated @ModelAttribute Todo todo, BindingResult errors, Model model) {
//		
//		if (!errors.hasErrors()) {
//			// Call the DAO function to check/uncheck the todo
//			this.todo.checkTodo(todo.getTodoID(), !todo.getChecked());
//		}
//		return ((errors.hasErrors()) ? "todo" : "redirect:/");
//	}

}
