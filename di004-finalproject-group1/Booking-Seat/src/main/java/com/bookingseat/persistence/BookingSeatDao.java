package com.bookingseat.persistence;

import java.util.List;

import com.bookingseat.entity.BookingSeat;

public interface BookingSeatDao {
	public int addBookingSeat(BookingSeat bookingSeat);
	public List<BookingSeat> getAllBookedSeats();
	public BookingSeat getSingleBookingSeat(int seatId, int basketId);
}
