package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.admin.entity.Admin;
import com.admin.persistence.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public Admin getAdminByUsernameAndPassword(Admin admin) {
		try {
		return adminDao.getAdminByUsernameAndPassword(admin.getAdminUsername(), admin.getPassword());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}
