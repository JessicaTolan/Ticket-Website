package com.reviews;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.reviews.entity.Review;
import com.reviews.persistence.ReviewDao;

@SpringBootTest
@ActiveProfiles("test")
class ReviewsApplicationTests {
	
	@Autowired
	ReviewDao reviewDao;
	
	@Test
	void Test_Add_1() {
		Review review = new Review("jEdmonds", "Great service! Everything was perfect.", 003, 4);
		assertEquals(1, reviewDao.addReview(review));
	}
	
	@Test
	void Test_Add_2() {
		Review review = new Review("Ellie", "Great service! Everything was perfect.", 001, 5);
		assertThrows(DataIntegrityViolationException.class, () -> reviewDao.addReview(review));
	}

	@Test
	void Test_Delete_1() {
		assertEquals(1, reviewDao.deleteReviewById(4));
	}
	
	@Test
	void Test_Delete_2() {
		assertEquals(0, reviewDao.deleteReviewById(8));
	}
	
	@Test
	void Test_View_1() {
		Review review = reviewDao.getReviewById(1);
		assertEquals("jEdmonds", review.getUsername());
	}
	
	@Test
	void Test_View_2() {
		assertThrows(EmptyResultDataAccessException.class, () -> reviewDao.getReviewById(8));
	}
	
	@Test
	void Test_Update_1() {
		assertEquals(1, reviewDao.updateReview(1, "Average"));
	}
	
	@Test
	void Test_Update_2() {
		assertEquals(0, reviewDao.updateReview(7, "Great Film!"));
	}
	
	@Test
	void Test_ViewAll_1() {
		assertEquals(3, reviewDao.getAllReviews().size());
	}
	
	
}
