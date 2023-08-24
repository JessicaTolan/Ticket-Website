package com.user.service;
import com.user.entity.User;
import java.util.List;

public interface UserService {
	
	int addUser(User user);
	int deleteUser(String username);
	int updatePassword(String username, String password);
	List<User> getAllUsers();
	User getUser(String username);
	User getUserByUsernameAndPassword(User user);
}
