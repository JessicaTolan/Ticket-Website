package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.entity.UserList;
import com.user.service.UserService;

@RestController
public class UserResource {

	@Autowired
	UserService userService;
	
	@PostMapping(path="/addUser", produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUserResource(@RequestBody User user){
		if(userService.addUser(user)>0)
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		else 
			return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path="/login")
	public User loginUser(@RequestBody User user) {
		return userService.getUserByUsernameAndPassword(user);
	}
	
	@DeleteMapping(path ="/deleteUser/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> deleteUserResource(@PathVariable String name){
		int user = userService.deleteUser(name);
		if(user>0)
			return new ResponseEntity<User>(HttpStatus.OK);
		else 
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "/updateUser/{name}/{password}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updatePasswordResource(@PathVariable("name")String name, @PathVariable("password") String password){
		int user = userService.updatePassword(name, password);
		if(user>0)
			return new ResponseEntity<User>(HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);

	}
	
	@CrossOrigin
	@GetMapping(path ="/users", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<UserList> getAllUsers(){
		UserList userList= new UserList(userService.getAllUsers());
		if(userList.getUserList().size()>0)
			return new ResponseEntity<UserList>(userList,HttpStatus.OK);
		else
			return new ResponseEntity<UserList>(HttpStatus.NO_CONTENT);	
	}
	
	@CrossOrigin
	@GetMapping(path ="/user/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserResource(@PathVariable("name") String name){
		User user = userService.getUser(name);
		if(user != null)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		else 
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	}

