package com.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.admin.entity.Admin;
import com.admin.persistence.AdminDao;

@SpringBootTest
@ActiveProfiles("test")
class AdminApplicationTests {
	
	@Autowired
	AdminDao adminDao;
	
	@Test
	void Test_login_1() {
		assertThrows(EmptyResultDataAccessException.class, () -> adminDao.getAdminByUsernameAndPassword("blahblah", "adddddddminnnnnn"));
	}
	
	@Test
	void Test_login_2() {
		Admin admin = adminDao.getAdminByUsernameAndPassword("admin", "admin");
		assertEquals("admin", admin.getAdminUsername());
	}

}
