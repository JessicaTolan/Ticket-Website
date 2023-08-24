package com.bookingseat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.bookingseat.entity.BookingSeat;
import com.bookingseat.persistence.BookingSeatDao;

@SpringBootTest
@ActiveProfiles("test")
class BookingSeatApplicationTests {
	
	@Autowired
	BookingSeatDao bookingSeatDao;

	@Test
	void Test_Add_1() {
		BookingSeat bookingSeat = new BookingSeat(48,3);
		assertEquals(1, bookingSeatDao.addBookingSeat(bookingSeat));
	}
	
	@Test
	void Test_Add_2() {
		BookingSeat bookingSeat = new BookingSeat(48,4);
		assertThrows(DataIntegrityViolationException.class, () -> bookingSeatDao.addBookingSeat(bookingSeat));
	}
	
	@Test
	void Test_ViewAll_1() {
		assertEquals(5, bookingSeatDao.getAllBookedSeats().size());
	}
	
	@Test
	void Test_View_1() {
		BookingSeat bookingSeat = bookingSeatDao.getSingleBookingSeat(1,1);
		assertEquals(1, bookingSeat.getBasketId());
	}
	
	@Test
	void Test_View_2() {
		assertThrows(EmptyResultDataAccessException.class, () -> bookingSeatDao.getSingleBookingSeat(8,13));
	}
}
