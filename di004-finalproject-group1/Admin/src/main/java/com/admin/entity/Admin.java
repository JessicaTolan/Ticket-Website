package com.admin.entity;

public class Admin {
	
	private String adminUsername;

	private String password;
	
	public Admin() {
		super();
	}

	public Admin(String adminUsername, String password) {
		super();
		this.adminUsername = adminUsername;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [admonUsername=" + adminUsername + ", password=" + password + "]";
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String admonUsername) {
		this.adminUsername = admonUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
