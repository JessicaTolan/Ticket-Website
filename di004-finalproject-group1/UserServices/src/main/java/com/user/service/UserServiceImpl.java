package com.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.persistence.UserDao;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int addUser(User user) {
		try {
			return userDao.addUser(user);
		}catch(Exception ex) {
		return 0;
		}
	}

	@Override
	public int deleteUser(String username) {
		try {
			return userDao.deleteUser(username);
		} catch(Exception ex) {
			return 0;
		}
	}

	@Override
	public int updatePassword(String username, String password) {
		try {
		return userDao.updatePassword(username, password);
		}catch(Exception ex) {
			return 0;
		}
	}

	@Override
	public List<User> getAllUsers() {
		try {
		return userDao.getAllUsers();
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public User getUser(String username) {
		try {
		return userDao.getUser(username);
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public User getUserByUsernameAndPassword(User user) {
		try {
		return userDao.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}catch(Exception ex) {
		return null;
	}
	}

}
