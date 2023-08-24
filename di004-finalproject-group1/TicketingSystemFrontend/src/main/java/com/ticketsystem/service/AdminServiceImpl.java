package com.ticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ticketsystem.entity.Admin;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	RestTemplate restTemplate;
	
	String baseURL="http://localhost:8080/";
	
	@Override
	public Admin getAdminByUsernameAndPassword(Admin admin) {
		return restTemplate.postForObject(baseURL+"login", admin, Admin.class);
	}
	
}
