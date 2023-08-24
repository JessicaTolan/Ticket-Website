package com.user.entity;
import java.util.List;

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
