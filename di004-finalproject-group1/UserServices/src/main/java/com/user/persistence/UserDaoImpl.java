package com.user.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import com.user.entity.User;
import com.user.persistence.UserMapper;



@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addUser(User user) {
		String query = "insert into user values(?,?,?,?,?)";
		return jdbcTemplate.update(query,user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword(),user.getEmail());
	}

	@Override
	public int deleteUser(String username) {
		String query = "delete from user where username=?";
		return jdbcTemplate.update(query, username);
	}

	@Override
	public int updatePassword(String username, String password) {
		String query = "update User set password = '"+password+"' where username = '" + username+"';";
		return jdbcTemplate.update(query);
	}

	@Override
	public List<User> getAllUsers() {
		String query = "Select * from user";
		return jdbcTemplate.query(query, new UserMapper());
	}

	@Override
	public User getUser(String username) {
		String query = "SELECT * FROM USER WHERE USERNAME = '"+username+"';";
		return jdbcTemplate.queryForObject(query,new UserMapper());
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		String query = "SELECT * FROM USER WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"';";
		return jdbcTemplate.queryForObject(query,new UserMapper());
	}

}
