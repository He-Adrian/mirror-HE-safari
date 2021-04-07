package ch.hearc.spring.hesafari.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	/// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
    
    @Column(unique = true, nullable = false, length = 20)
	private String username;
    
    @Column(nullable = false, length = 64)
	private String password;
    
    @Column(name = "role", nullable = false, length = 20)
	private String role = "User";
    
    @Column(name = "className", nullable = false, length = 20)
	private String className;
    
    @Column(name = "reputation", nullable = false, length = 20)
	private int reputation = 0;

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
