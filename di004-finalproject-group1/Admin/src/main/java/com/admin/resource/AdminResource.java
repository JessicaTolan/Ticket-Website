package com.admin.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.Admin;
import com.admin.service.AdminService;
@RestController
public class AdminResource {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping(path="/login")
	public Admin loginAdmin(@RequestBody Admin admin) {
		try {
			return adminService.getAdminByUsernameAndPassword(admin);
		}catch(Exception e) {
			return null;
		}
	}
}
