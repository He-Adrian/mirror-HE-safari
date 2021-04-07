package ch.hearc.spring.hesafari.model;

public class Break {

	/// Attributes
	private int breakID;
	private int from;
	private int to;
	private String location;

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
	public Break(int breakID, int from, int to, String location) {
		this.breakID = breakID;
		this.from = from;
		this.to = to;
		this.location = location;
	}

	/**
	 * Getters and Setters
	 */

	public int getBreakID() {
		return breakID;
	}

	public void setBreakID(int breakID) {
		this.breakID = breakID;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
