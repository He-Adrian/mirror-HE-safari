//package ch.hearc.spring.hesafari.data;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import org.springframework.stereotype.Component;
//
//import ch.hearc.spring.hesafari.model.Todo;
//import ch.hearc.spring.hesafari.model.TodoPriority;
//
///**
// * DAO = Data Access Object
// * Used to have an access to model entities
// * @author javaee
// *
// */
//@Component
//public class TodoDAO {
//
//	// List of all todos
//	private static Map<Integer, Todo> todos = new HashMap<>();
//
//	// Attributes used to count total todo time
//	private int totalTime = 0;
//
//	
//	/**
//	 * Fill the todo list with fake data
//	 */
//	static {
//		
//		SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
//		
//		try {
//			todos.put(1, new Todo(1, "Denis Prêtre", "Préparer l'année 2021", 200, TodoPriority.HIGH,
//					formater.parse("02.09.2021")));
//			todos.put(5, new Todo(5, "Gabriel", "Assister le cours JEE", 1, TodoPriority.HIGH,
//					formater.parse("01.10.2020")));
//			todos.put(2, new Todo(2, "Nabil", "Préparer le cours JEE", 2, TodoPriority.MEDIUM,
//					formater.parse("02.10.2020")));
//			todos.put(3, new Todo(3, "Étudiant A", "Réviser le cours JEE", 5000, TodoPriority.WHOCARES,
//					formater.parse("02.09.2020")));
//			todos.put(4, new Todo(4, "Étudiant B", "Jouer à Hearthstone", 10, TodoPriority.LOW,
//					formater.parse("02.09.2022")));
//
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	//****************//
//	// FUNCTION TODOS //
//	//****************//
//		
//	/**
//	 * return the list of todos
//	 * 
//	 * @return
//	 */
//	public List<Todo> getAllTodos() {
//		return todos.values().stream().sorted((todoA, todoB) -> todoA.getDate().compareTo(todoB.getDate()))
//				.collect(Collectors.toList());
//	}
//	
//	
//	/**
//	 * Return a list of todos by the given date
//	 * @param date
//	 * @return
//	 */
//	public List<Todo> getAllTodosByDate(Date date)
//	{		
//		Map<Date, List<Todo>> myMap = todos.values().stream().collect(Collectors.groupingBy(todo -> todo.getDate()));
//		return myMap.get(date);
//		//return todos.values().stream().collect(Collectors.groupingBy(todo -> todo.getDate())).;
//	}
//
//	
//	/**
//	 * Save a new todo t by adding it in the list
//	 * 
//	 * @param t
//	 */
//	public boolean saveTodo(Todo t) {
//		if(t.validate())
//		{
//			int id = newKey();
//			t.setTodoID(id);
//			todos.put(id, t);
//			return true;
//		}
//		else
//		{
//			return false;
//		}
//
//	}
//
//	/**
//	 * Check/Uncheck a todo
//	 * 
//	 * @param t
//	 * @param check
//	 */
//	public void checkTodo(int todoID, Boolean check) {
//		Todo foundTodo = todos.values().stream().filter(todo -> todo.getTodoID() == todoID).findAny().orElse(null);
//		foundTodo.setChecked(check);
//	}
//
//	/**
//	 * Return total time for todos
//	 * 
//	 * @return
//	 */
//	public int getTotalTime() {
//		totalTime = 0;
//		getAllTodos().stream().filter(todo -> todo.getChecked() == false).forEach((x) -> {
//			totalTime += x.getTime();
//		});
//		return totalTime;
//	}
//	
//	/**
//	 * Return total time for todos from the given date
//	 * 
//	 * @return
//	 */
//	public int getTotalTime(Date date) {
//		totalTime = 0;
//		if(getAllTodosByDate(date) != null)
//		{
//			getAllTodosByDate(date).stream().filter(todo -> todo.getChecked() == false).forEach((x) -> {
//				totalTime += x.getTime();
//			});
//			return totalTime;
//		}
//		return 0;
//		
//	}
//	
//
//	/**
//	 * Retrieve a new key used for the id
//	 * 
//	 * @return
//	 */
//	private static Integer newKey() {
//		final Comparator<Integer> comp = (k1, k2) -> Integer.compare(k1, k2);
//
//		// return todosToday.keySet().stream().max(comp).get() + 1;
//		return Collections.max(todos.keySet(), comp) + 1;
//	}
//}
