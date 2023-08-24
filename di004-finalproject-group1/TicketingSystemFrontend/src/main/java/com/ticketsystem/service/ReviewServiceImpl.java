package com.ticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ticketsystem.entity.Review;
import com.ticketsystem.entity.ReviewList;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	String baseURL = "http://localhost:8086/";
	
	@Override
	public Review addReview(Review review) {
		System.out.println(review.getUsername());
		restTemplate.postForEntity(baseURL+"addReviews", review, Review.class);
		return review;
	}

	@Override
	public Review getReviewById(int reviewId) {
		Review review = restTemplate.getForObject(baseURL+"reviews/"+reviewId, Review.class);
		return review;
	}

	@Override
	public List<Review> getAllReviews() {
		 ReviewList reviewList = restTemplate.getForObject("http://localhost:8086/reviews", ReviewList.class);
		 List<Review> list = reviewList.getReviews();
		return list;
	}

	@Override
	public int deleteReviewById(int reviewId) {
		restTemplate.delete(baseURL+"deleteReview/"+reviewId);
		return 1;
	}

	@Override
	public Review updateReview(int reviewId, String reviewText) {
		restTemplate.put(baseURL+"updateReview/"+reviewId, reviewText, Review.class);
		Review updatedReview = restTemplate.getForObject(baseURL+"reviews/"+reviewId, Review.class);
		return updatedReview;
	}

	@Override
	public List<Review> getAllReviewsForAShow(int ticketId) {
		ReviewList reviewList = restTemplate.getForObject("http://localhost:8086/reviewsForShow/"+ticketId, ReviewList.class);
		List<Review> list = reviewList.getReviews();
 		return list;
	}

}
