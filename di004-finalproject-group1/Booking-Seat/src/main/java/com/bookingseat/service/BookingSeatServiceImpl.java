package com.bookingseat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingseat.entity.BookingSeat;
import com.bookingseat.persistence.BookingSeatDao;
@Service
public class BookingSeatServiceImpl implements BookingSeatService {
	
	@Autowired
	BookingSeatDao bookingSeatDao;
	
	@Override
	public int addBookingSeat(BookingSeat bookingSeat) {
		try {
			return bookingSeatDao.addBookingSeat(bookingSeat);
			}
			catch(Exception ex) {
				return 0;
			}
	}

	@Override
	public List<BookingSeat> getAllBookedSeats() {
		return bookingSeatDao.getAllBookedSeats();
	}

	@Override
	public BookingSeat getSingleBookingSeat(int seatId, int basketId) {
		try {
			return bookingSeatDao.getSingleBookingSeat(seatId, basketId);
			}
			catch(Exception ex) {
				return null;
			}
	}

}
