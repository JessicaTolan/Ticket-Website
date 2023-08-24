package com.seat.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seat.entity.Seat;
import com.seat.entity.SeatList;
import com.seat.service.SeatService;

@RestController
public class SeatResource {

	@Autowired
	SeatService seatService;
	
	@CrossOrigin
	@GetMapping(path="/seats",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<SeatList> getAllSeats() {
		SeatList seatList= new SeatList(seatService.getAllSeats());
		if(seatList.getSeats().size()>0)
			return new ResponseEntity<SeatList>(seatList,HttpStatus.OK);
		else
			return new ResponseEntity<SeatList>(seatList,HttpStatus.NO_CONTENT);
	}

	@CrossOrigin
	@GetMapping(path ="/seats/{sId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seat> getSingleSeatWithID(@PathVariable("sId") int seatId) {
		Seat seat=seatService.getSingleSeat(seatId);
		ResponseEntity response=null;
		if(seat!=null)
			response=new ResponseEntity<Seat>(seat, HttpStatus.FOUND);
		else
			response=new ResponseEntity<Seat>(seat,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@CrossOrigin
	@GetMapping(path = "/reviewsForShow/{tId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SeatList> getAllSeatsForVenueResource(@PathVariable("venue") String venueName) {
		SeatList seatLsit=(SeatList) seatService.getAllSeatsForVenue(venueName);
		ResponseEntity response=null;
		if(seatLsit!=null)
			response=new ResponseEntity<SeatList>(seatLsit, HttpStatus.FOUND);
		else
			response=new ResponseEntity<SeatList>(seatLsit,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@PostMapping(path = "/addReviews",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seat> addVenueResource(@RequestBody Seat seat) {
		if(seatService.addSeat(seat) > 0)
			return new ResponseEntity<Seat>(seat, HttpStatus.CREATED);
		else
			return new ResponseEntity<Seat>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping(path = "/deleteSeat/{sId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seat> deleteSeatResource(@PathVariable("sId") int seatId) {
		if(seatService.deleteSeat(seatId) > 0)
			return new ResponseEntity<Seat>(HttpStatus.OK);
		else
			return new ResponseEntity<Seat>(HttpStatus.NO_CONTENT);
	}
	
}
