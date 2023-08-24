package com.user.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import com.user.entity.User;
import com.user.persistence.UserDao;


@SpringBootTest
@ActiveProfiles("test")
public class UserServicesApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAddUser() {
        User user =  new User("testuser", "John", "Doe", "password", "john.doe@example.com");
        assertEquals(1, userDao.addUser(user));
    }
    
    @Test
    public void testDeleteUser() {
        
        assertEquals(1, userDao.deleteUser("testuser"));
    }
    @Test
    public void testUpdatePassword() {
        userDao.updatePassword("testuser", "password");
        User user = userDao.getUser("testuser");
        assertEquals("password", user.getPassword());
    }
    @Test
    public void testGetAllUsers() {
    	assertEquals(6, userDao.getAllUsers().size());
    }
    
    @Test
    public void testGetUser() {
    User user = userDao.getUser("testuser");
    assertEquals("John", user.getFirstName());
    }
    
	@Test
	void testLogin() {
		assertThrows(EmptyResultDataAccessException.class, () -> userDao.getUserByUsernameAndPassword("user1", "password1"));
	}

}

