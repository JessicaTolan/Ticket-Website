package com.seat.service;

import java.util.List;

import com.seat.entity.Seat;

public interface SeatService {
	public int addSeat(Seat seat);
	public int deleteSeat(int seatId);
	public List<Seat> getAllSeats();
	public List<Seat> getAllSeatsForVenue(String venueName);
	public Seat getSingleSeat(int seatId);
}
