package ch.hearc.spring.hesafari.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import ch.hearc.spring.hesafari.model.Break;

/**
 * DAO = Data Access Object Used to have an access to model entities
 * 
 * @author javaee
 *
 */
@Component
public class BreakDAO {

	// List of all todos
	private static Map<Integer, Break> breaks = new HashMap<>();

	// Attributes used to count total todo time
	private int totalTime = 0;

	/**
	 * Fill the todo list with fake data
	 */
	static {

//		breaks.put(1, new Break(1, new Date(), new Date(), "Cafetéria", "Grosse teuf"));
	}

	// ****************//
	// FUNCTION TODOS //
	// ****************//

	/**
	 * return the list of todos
	 * 
	 * @return
	 */
	public List<Break> getAllbreaks() {
		return breaks.values().stream().collect(Collectors.toList());
	}

	/**
	 * Save a new todo t by adding it in the list
	 * 
	 * @param t
	 */
	public boolean saveBreak(Break newBreak) {
		int id = newKey();
		newBreak.setBreakID(id);
		breaks.put(id, newBreak);
		return true;
	}

	/**
	 * Retrieve a new key used for the id
	 * 
	 * @return
	 */
	private static Integer newKey() {
		final Comparator<Integer> comp = (k1, k2) -> Integer.compare(k1, k2);

		// return todosToday.keySet().stream().max(comp).get() + 1;
		return Collections.max(breaks.keySet(), comp) + 1;
	}
}
