package ch.hearc.spring.hesafari.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Set;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "breaks")
public class Break {

	/// Attributes
	/// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long breakID;

	@DateTimeFormat(pattern = "h:mm a")
	@Column(name = "fromDate", unique = false, nullable = false)
	private Time from;

	@DateTimeFormat(pattern = "h:mm a")
	@Column(name = "toDate", unique = false, nullable = false)
	private Time to;

	@Column(unique = true, nullable = false, length = 20)
	private String location;

	@Column(unique = true, nullable = false, length = 100)
	private String description;

	@ManyToOne
	private User owner;
//
	@ManyToMany(mappedBy = "attendedBreaks", fetch = FetchType.EAGER)
	Set<User> attends = Collections.emptySet();

	public Break() {
		///
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param from
	 * @param to
	 * @param location
	 */
	public Break(int breakID, Time from, Time to, String location, String description) {
		this.breakID = breakID;
		this.from = from;
		this.to = to;
		this.location = location;
		this.description = description;
	}

	/**
	 * Getters and Setters
	 */

	public long getBreakID() {
		return breakID;
	}

	public void setBreakID(long breakID) {
		this.breakID = breakID;
	}

	public Time getFrom() {
		return from;
	}

	public void setFrom(String strFrom) {
//		try {
//			this.from = new SimpleDateFormat("H:mm").parse(strFrom);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.from = Time.valueOf(String.format("%s:00", strFrom));
	}

	public Time getTo() {
		return to;
	}

	public void setTo(String strTo) {
//		this.to = Date.valueOf(strFrom);// new SimpleDateFormat("H:mm").parse(strFrom);
		this.to = Time.valueOf(String.format("%s:00", strTo));
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getAttends() {
		return attends;
	}

	public void setAttends(Set<User> attends) {
		this.attends = attends;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
