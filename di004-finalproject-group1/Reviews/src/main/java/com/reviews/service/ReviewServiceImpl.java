package com.reviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.reviews.entity.Review;
import com.reviews.persistence.ReviewDao;
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;
	
	@Override
	public int addReview(Review review) {
		try {
			return reviewDao.addReview(review);
			}
			catch(Exception ex) {
				return 0;
			}
	}

	@Override
	public Review getReviewById(int reviewId) {
		try {
			return reviewDao.getReviewById(reviewId);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Review> getAllReviews() {
		return reviewDao.getAllReviews();
	}

	@Override
	public int deleteReviewById(int reviewId) {
		Review review=getReviewById(reviewId);
		if(review!=null) {
			return reviewDao.deleteReviewById(reviewId);
		}
		return 0;
	}

	@Override
	public int updateReview(int reviewId, String review) {
		return reviewDao.updateReview(reviewId, review);
	}

	@Override
	public List<Review> getAllReviewsForAShow(int ticketId) {
		try {
			return reviewDao.getAllReviewsForAShow(ticketId);
		}catch(Exception e) {
			return null;
		}
	}

}
