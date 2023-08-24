package com.seat.persistence;

import java.util.List;

import com.seat.entity.Seat;

public interface SeatDao {
	public int addSeat(Seat seat);
	public int deleteSeat(int seatId);
	public List<Seat> getAllSeats();
	public List<Seat> getAllSeatsForVenue(String venueName);
	public Seat getSingleSeat(int seatId);
}
