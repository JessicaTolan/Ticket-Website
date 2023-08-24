package com.reviews.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.reviews.entity.Review;
import com.reviews.entity.ReviewList;
import com.reviews.service.ReviewService;

@RestController
public class ReviewResource {
	
	@Autowired
	ReviewService reviewService;
	
	@CrossOrigin
	@GetMapping(path="/reviews",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<ReviewList> getAllReviews() {
		ReviewList reviewList= new ReviewList(reviewService.getAllReviews());
		if(reviewList.getReviews().size()>0)
			return new ResponseEntity<ReviewList>(reviewList,HttpStatus.OK);
		else
			return new ResponseEntity<ReviewList>(reviewList,HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@GetMapping(path = "/reviews/{rId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> searchReviewByIdResource(@PathVariable("rId") int reviewId) {
		Review review=reviewService.getReviewById(reviewId);
		ResponseEntity response=null;
		if(review!=null)
			response=new ResponseEntity<Review>(review, HttpStatus.FOUND);
		else
			response=new ResponseEntity<Review>(review,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@CrossOrigin
	@PostMapping(path = "/addReviews",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> addReviewResourcec(@RequestBody Review review) {
		if(reviewService.addReview(review) > 0)
			return new ResponseEntity<Review>(review, HttpStatus.CREATED);
		else
			return new ResponseEntity<Review>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@CrossOrigin
	@DeleteMapping(path = "/deleteReview/{rId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> deleteReviewResource(@PathVariable("rId") int rId) {
		if(reviewService.deleteReviewById(rId) > 0)
			return new ResponseEntity<Review>(HttpStatus.OK);
		else
			return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@PutMapping(path = "/updateReview/{rId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> updateReview(@PathVariable("rId") int reviewId,@RequestBody String review){
		if(reviewService.updateReview(reviewId, review) >0)
			return new ResponseEntity<Review>(HttpStatus.OK);
		else
			return new ResponseEntity<Review>(HttpStatus.BAD_REQUEST);	
	}
	
	@CrossOrigin
	@GetMapping(path = "/reviewsForShow/{tId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReviewList> searchReviewByShowIdResource(@PathVariable("tId") int ticketId) {
		ReviewList reviewList= new ReviewList(reviewService.getAllReviewsForAShow(ticketId));
		ResponseEntity response=null;
		try {
		if(reviewList.getReviews().size()>0)
			response=new ResponseEntity<ReviewList>(reviewList, HttpStatus.FOUND);
		else
			response=new ResponseEntity<ReviewList>(reviewList,HttpStatus.NOT_FOUND);
		return response;
	}catch(Exception e) {
		return null;
	}
	}
}
