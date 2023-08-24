package com.user.persistence;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.user.entity.User;

public class UserMapper implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		User user = new User();
		
		user.setUsername(rs.getString("USERNAME"));
		user.setFirstName(rs.getString("FIRSTNAME"));
		user.setLastName(rs.getString("LASTNAME"));
		user.setEmail(rs.getString("EMAIL"));
		user.setPassword(rs.getString("PASSWORD"));
		
		return user;
	}
}
