package com.admin.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.admin.entity.Admin;

public class AdminMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		String adminUsername = resultSet.getString("ADMINUSERNAME");
		String password = resultSet.getString("PASSWORD");

		
		Admin admin = new Admin(adminUsername,password);
		return admin;
	}

}
