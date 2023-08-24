package com.seat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seat.entity.Seat;
import com.seat.persistence.SeatDao;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatDao seatDao;
	
	@Override
	public int addSeat(Seat seat) {
		try {
			return seatDao.addSeat(seat);
			}
			catch(Exception ex) {
				return 0;
			}
	}

	@Override
	public int deleteSeat(int seatId) {
		Seat seat= getSingleSeat(seatId);
		if(seat!=null) {
			return seatDao.deleteSeat(seatId);
		}
		return 0;
	}

	@Override
	public List<Seat> getAllSeats() {
		return seatDao.getAllSeats();
	}

	@Override
	public List<Seat> getAllSeatsForVenue(String venueName) {
		return seatDao.getAllSeatsForVenue(venueName);
	}

	@Override
	public Seat getSingleSeat(int seatId) {
		try {
			return seatDao.getSingleSeat(seatId);
			}
			catch(Exception ex) {
				return null;
			}
	}

}
