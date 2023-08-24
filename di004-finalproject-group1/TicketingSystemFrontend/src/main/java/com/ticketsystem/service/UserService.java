package com.ticketsystem.service;

import java.util.List;

import com.ticketsystem.entity.User;

public interface UserService {
	public User addUser(User user);
	public int deleteUser(String username);
	public User updatePassword(String username, String password);
	public List<User> getAllUsers();
	public User getUser(String username);
	public User getUserByUsernameAndPassword(User user);
}
