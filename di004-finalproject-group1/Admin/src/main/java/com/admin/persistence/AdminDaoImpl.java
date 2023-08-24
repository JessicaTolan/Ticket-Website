package com.admin.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.admin.entity.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Admin getAdminByUsernameAndPassword(String username, String password) {
		String query = "SELECT * FROM ADMIN WHERE ADMINUSERNAME = '"+username+"' AND PASSWORD = '"+password+"';";
		return jdbcTemplate.queryForObject(query, new AdminMapper());
	}

}
