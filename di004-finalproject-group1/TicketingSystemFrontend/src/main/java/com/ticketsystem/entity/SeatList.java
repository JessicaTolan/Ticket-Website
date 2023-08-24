package com.ticketsystem.entity;

import java.util.List;

public class SeatList {
	List<Seat> seats;

	public SeatList(List<Seat> seats) {
		super();
		this.seats = seats;
	}

	public SeatList() {
		super();
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "SeatList [seats=" + seats + "]";
	}
	
}
