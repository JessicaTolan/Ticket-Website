package com.user.persistence;
import java.util.List;
import com.user.entity.User;

public interface UserDao { 
	
	public User getUserByUsernameAndPassword(String username, String password);
	public int addUser(User user);
	public int deleteUser(String username);
	public int updatePassword(String username, String password);
	public List<User> getAllUsers();
	public User getUser(String username);

}
