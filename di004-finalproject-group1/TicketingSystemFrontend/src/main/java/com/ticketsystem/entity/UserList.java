package com.ticketsystem.entity;

import java.util.List;

import com.ticketsystem.entity.UserList;

public class UserList {
List<User> UserList;

public List<User> getUserList() {
	return UserList;
}

public void setUserList(List<User> userList) {
	UserList = userList;
}

public UserList(List<User> userList) {
	super();
	UserList = userList;
}

public UserList() {
	super();
}


}
