package com.bookingseat.service;

import java.util.List;

import com.bookingseat.entity.BookingSeat;

public interface BookingSeatService {
	public int addBookingSeat(BookingSeat bookingSeat);
	public List<BookingSeat> getAllBookedSeats();
	public BookingSeat getSingleBookingSeat(int seatId, int basketId);
}
