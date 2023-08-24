package com.ticketsystem.service;

import com.ticketsystem.entity.Admin;

public interface AdminService {
	public Admin getAdminByUsernameAndPassword(Admin admin);
}
