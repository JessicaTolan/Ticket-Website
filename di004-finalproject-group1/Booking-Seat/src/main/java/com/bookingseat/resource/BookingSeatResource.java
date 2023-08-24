package com.bookingseat.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookingseat.entity.BookingSeat;
import com.bookingseat.service.BookingSeatService;


@RestController
public class BookingSeatResource {

	@Autowired
	BookingSeatService bookingSeatService;
	
	@GetMapping(path = "/bookedSeats",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookingSeat> getAllBookedSeats() {
		return bookingSeatService.getAllBookedSeats();
	}
	
	@CrossOrigin
	@GetMapping(path = "/bookedSeats/{sId}/{bId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingSeat> getSingleBookedSeatResource(@PathVariable("sId") int seatId, @PathVariable("bId") int basketId) {
		BookingSeat bookedSeat = bookingSeatService.getSingleBookingSeat(seatId, basketId);
		ResponseEntity response=null;
		if(bookedSeat!=null)
			response=new ResponseEntity<BookingSeat>(bookedSeat, HttpStatus.FOUND);
		else
			response=new ResponseEntity<BookingSeat>(bookedSeat,HttpStatus.NOT_FOUND);
		return response;
	}
	
	
	@PostMapping(path = "/addSeat",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookingSeat> addBookedSeat(@RequestBody BookingSeat bookingSeat) {
		if(bookingSeatService.addBookingSeat(bookingSeat) > 0)
			return new ResponseEntity<BookingSeat>(bookingSeat, HttpStatus.CREATED);
		else
			return new ResponseEntity<BookingSeat>(HttpStatus.NOT_ACCEPTABLE);
	}
	
}
