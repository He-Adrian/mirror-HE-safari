package ch.hearc.spring.todo.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Todo {

	/// Attributes
	private int todoID;
	private String author;
	private String message;
	private Boolean checked;
	private TodoPriority priority;
	private int time;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	
	/**
	 * Default Constructor
	 */
	public Todo() {
		// Auto-generated constructor stub
	}

	
	/**
	* Constructor
	 * 
	 * @param id
	 * @param author
	 * @param message
	 * @param time
	 * @param priority
	 */
	public Todo(int id, String author, String message, int time, TodoPriority priority, Date date) {
		this.todoID = id;
		this.author = author;
		this.message = message;
		this.priority = priority;
		this.checked = false;
		this.time = time;
		this.date = date;

	}
	
	/**
	 * Function used to know if the doto is valid
	 * @return
	 */
	public boolean validate()
	{
		return (!author.isEmpty() && !message.isEmpty() && priority != null && date != null);
	}

	/**
	 * Getters and Setters
	 */
	public int getTodoID() {
		return todoID;
	}

	public void setTodoID(int id) {
		todoID = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Used to retrieve the time in format "145"
	 * 
	 * @return
	 */
	public int getTime() {
		return time;
	}

	public TodoPriority getPriority() {
		return priority;
	}

	public void setPriority(final TodoPriority priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
