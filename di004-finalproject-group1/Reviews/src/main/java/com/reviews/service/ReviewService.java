package com.reviews.service;

import java.util.List;

import com.reviews.entity.Review;

public interface ReviewService {
	public int addReview(Review review);
	public Review getReviewById(int reviewId);
	public List<Review> getAllReviews();
	public int deleteReviewById(int reviewId);
	public int updateReview(int reviewId, String review);
	public List<Review> getAllReviewsForAShow(int ticketId);
}
