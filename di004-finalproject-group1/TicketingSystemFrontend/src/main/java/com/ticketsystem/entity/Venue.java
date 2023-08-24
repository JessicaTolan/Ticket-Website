package com.ticketsystem.entity;

public class Venue {
	
	private String venueName;
	private int capacity;
	public Venue(String venueName, int capacity) {
		super();
		this.venueName = venueName;
		this.capacity = capacity;
	}
	public Venue() {
		super();
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Venue [venueName=" + venueName + ", capacity=" + capacity + "]";
	}
	
	
}
