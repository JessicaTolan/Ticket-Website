package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.entity.Review;

public interface ReviewService {
	public Review addReview(Review review);
	public Review getReviewById(int reviewId);
	public List<Review> getAllReviews();
	public int deleteReviewById(int reviewId);
	public Review updateReview(int reviewId, String review);
	public List<Review> getAllReviewsForAShow(int ticketId);
}
