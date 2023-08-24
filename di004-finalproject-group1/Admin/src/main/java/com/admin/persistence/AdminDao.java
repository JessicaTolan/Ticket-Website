package com.admin.persistence;

import com.admin.entity.Admin;

public interface AdminDao {
	public Admin getAdminByUsernameAndPassword(String username, String password);
}
