package com.reviews.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reviews.entity.Review;

public class ReviewMapper implements RowMapper<Review> {

	@Override
	public Review mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		String username = resultSet.getString("USERNAME");
		String review = resultSet.getString("REVIEW");
		int reviewId = resultSet.getInt("REVIEWID");
		int ticketId = resultSet.getInt("TICKETID");
		
		Review reviewCreated = new Review(username, review, ticketId, reviewId);
		return reviewCreated;
	}
	
	
	
}
