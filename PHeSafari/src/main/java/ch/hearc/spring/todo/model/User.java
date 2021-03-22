package ch.hearc.spring.todo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	/// Attributes
	private int userID;
	private String username;
	private String password;
	private String role;
	private String className;
	private int reputation;

	/**
	 * Default Constructor
	 */
	public User() {
		// Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @param role
	 * @param className
	 * @param reputation
	 */
	public User(int userID, String username, String password, String role, String className, int reputation) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.role = role;
		this.className = className;
		this.reputation = reputation;
	}

	/**
	 * Getters and Setters
	 */

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

}
