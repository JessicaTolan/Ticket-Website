package com.reviews.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.reviews.entity.Review;
@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int addReview(Review review) {
		String query = "insert into review values(?,?,?,?)";
		return jdbcTemplate.update(query, review.getUsername(), review.getReview(), review.getTicketId(), review.getReviewId());
	}

	@Override
	public Review getReviewById(int reviewId) {
		String query = "SELECT * FROM REVIEW WHERE REVIEWID = "+reviewId;
		return jdbcTemplate.queryForObject(query, new ReviewMapper());
	}

	@Override
	public List<Review> getAllReviews() {
		String query = "SELECT * FROM REVIEW";
		return jdbcTemplate.query(query, new ReviewMapper());
	}

	@Override
	public int deleteReviewById(int reviewId) {
		String query = "DELETE FROM REVIEW WHERE REVIEWID = ?";
		return jdbcTemplate.update(query, reviewId);
	}

	@Override
	public int updateReview(int reviewId, String review) {
		String query = "update review set review = '"+review+"' where reviewId = " + reviewId;
		return jdbcTemplate.update(query);
	}

	@Override
	public List<Review> getAllReviewsForAShow(int ticketId) {
		String query = "SELECT * FROM REVIEW WHERE TICKETID = "+ticketId;
		return jdbcTemplate.query(query, new ReviewMapper());
	}

}
