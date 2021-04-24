package ch.hearc.spring.hesafari.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

public class Break {

	/// Attributes
	private int breakID;
	@DateTimeFormat(pattern = "h:mm a")
	private Date from;
	@DateTimeFormat(pattern = "h:mm a")
	private Date to;
	private String location;
	private String description;

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
	public Break(int breakID, Date from, Date to, String location, String description) {
//		this.breakID = breakID;
		this.from = from;
		this.to = to;
		this.location = location;
		this.description = description;
	}

	/**
	 * Getters and Setters
	 */

//	public int getBreakID() {
//		return breakID;
//	}
//
//	public void setBreakID(int breakID) {
//		this.breakID = breakID;
//	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(String strFrom){
		try {
			this.from = new SimpleDateFormat("H:mm").parse(strFrom);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getTo() {
		return to;
	}

	public void setTo(String strFrom){
		try {
			this.to = new SimpleDateFormat("H:mm").parse(strFrom);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
