package com.ticketsystem.entity;

public class Seat {
	private int seatId;
	private int seatNumber;
	private String venueName;
	public Seat(int seatId, int seatNumber, String venueName) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.venueName = venueName;
	}
	public Seat() {
		super();
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatNumber=" + seatNumber + ", venueName=" + venueName + "]";
	}
	
	
}
