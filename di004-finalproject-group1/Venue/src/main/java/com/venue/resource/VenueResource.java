package com.venue.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venue.entity.Venue;
import com.venue.entity.VenueList;
import com.venue.service.VenueService;

@RestController
public class VenueResource {
	
	@Autowired
	VenueService venueService;
	
	@CrossOrigin
	@GetMapping(path="/venues",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<VenueList> getAllVenues() {
		VenueList venueList= new VenueList(venueService.getAllVenues());
		if(venueList.getVenues().size()>0)
			return new ResponseEntity<VenueList>(venueList,HttpStatus.OK);
		else
			return new ResponseEntity<VenueList>(venueList,HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@GetMapping(path =  "/venues/{vName}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venue> searchReviewByIdResource(@PathVariable("vName") String venueName) {
		Venue venue=venueService.getVenueByName(venueName);
		ResponseEntity response=null;
		if(venue!=null)
			response=new ResponseEntity<Venue>(venue, HttpStatus.FOUND);
		else
			response=new ResponseEntity<Venue>(venue,HttpStatus.NOT_FOUND);
		return response;
	}

	@PostMapping(path = "/addVenues",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venue> addVenueResource(@RequestBody Venue venue) {
		if(venueService.addVenue(venue) > 0)
			return new ResponseEntity<Venue>(venue, HttpStatus.CREATED);
		else
			return new ResponseEntity<Venue>(HttpStatus.NOT_ACCEPTABLE);
	}

	@DeleteMapping(path ="/deleteVenues/{vName}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venue> deleteReviewResource(@PathVariable("vName") String venueName) {
		if(venueService.deleteVenue(venueName) > 0)
			return new ResponseEntity<Venue>(HttpStatus.OK);
		else
			return new ResponseEntity<Venue>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "/updateReview/{vName}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venue> updateVenueCap(@PathVariable("vName") String venueName,@PathVariable int capacity){
		if(venueService.updateVenueCapacity(venueName, capacity) >0)
			return new ResponseEntity<Venue>(HttpStatus.OK);
		else
			return new ResponseEntity<Venue>(HttpStatus.BAD_REQUEST);	
	}
	
}
