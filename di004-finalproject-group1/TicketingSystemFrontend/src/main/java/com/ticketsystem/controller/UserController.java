package com.ticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import com.ticketsystem.entity.Ticket;
import com.ticketsystem.entity.User;
import com.ticketsystem.entity.UserList;
import com.ticketsystem.service.TicketService;
import com.ticketsystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	TicketService ticketService;
	
	@RequestMapping("/InputUsername")
	public ModelAndView InputUsernameController() {
		return new ModelAndView("InputUsername");
	}
	
	
	@RequestMapping("/searchUsername")
	public ModelAndView searchByUsernameController(@RequestParam("name")String username) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.getUser(username);
		if (user != null) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("ShowUser");
		} else {
			modelAndView.addObject("message", "The username " +username+ " does not exist");
			modelAndView.setViewName("Output");
		} return modelAndView;
	}
	
	@RequestMapping("/InputNewUserDetails")
	public ModelAndView InputNewUserDetailsController() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("InputNewUserDetails");
		return modelAndView;
	}
	
//	@RequestMapping("/saveUser")
//	public ModelAndView saveDetailsController(@ModelAttribute("user")User user) {
//		ModelAndView modelAndView=new ModelAndView();
//		String message = null;
//		
//		
//		if(userService.addUser(user) != null)
//			message = "User Successfully Added";
//		else
//			message = "Unsuccessful registration, try again later";
//		modelAndView.addObject("message", message);
//		modelAndView.setViewName("Output");
//
//		return modelAndView;
//	}
	
	@RequestMapping("/saveUser")
	public ModelAndView saveDetailsController(@ModelAttribute("user") User user) {
	    ModelAndView modelAndView = new ModelAndView();
	    String message;

	    
	    boolean isUsernameTaken = userService.getUser(user.getUsername()) != null;

	    if (isUsernameTaken) {
	       
	        message = "Username already exists. Please choose a different username.";
	    } else {
	     
	        User savedUser = userService.addUser(user);
	        if (savedUser != null) {
	            message = "User Successfully Added";
	        } else {
	            message = "Unsuccessful registration, try again later";
	        }
	    }

	    modelAndView.addObject("message", message);
	    modelAndView.setViewName("Output");

	    return modelAndView;
	}

	
	
	@RequestMapping("/InputUserToDelete")
	public ModelAndView inputLocationForDeleteController() {
		return new ModelAndView("InputUserToDelete");
	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUserController(@ModelAttribute("username")String username) {
		ModelAndView modelAndView=new ModelAndView();
		String message = null;
		boolean userExists = userService.getUser(username) != null;
		
		if(userExists) {
		if(userService.deleteUser(username) >0) {
			message = "User: " + username + " successfully deleted";
		} else {
			message = "User: " + username + " unsuccessfully deleted";
		}
		} else {
	        message = "User: " + username + " does not exist";
	    }
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	@RequestMapping("/InputPasswordForUpdate")
	public ModelAndView InputPasswordForUpdateController(){
		return new ModelAndView("InputPasswordForUpdate");
	}

	@RequestMapping("/updatePassword")
	public ModelAndView updatePasswordController(@RequestParam("username") String username, @RequestParam("password") String password) {
		String message=null;
boolean userExists = userService.getUser(username) != null;
		
		if(userExists) {
		if(userService.updatePassword(username, password) != null)
			message ="User " +username+ " password updated successfully";
		else 
			message ="User " +username+ " password not updated";
		} else {
	        message = "User: " + username + " does not exist";
	    }
		return new ModelAndView("Output", "message", message);
	}
	
	@RequestMapping("/user")
	public ModelAndView getLoginPageController() {
		return new ModelAndView("UserLoginPage", "user", new User());
	}
	
	@RequestMapping("/userLogin")
	public ModelAndView loginController(@ModelAttribute("user") User user, HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		User loginUser=userService.getUserByUsernameAndPassword(user);
		if(loginUser!=null) {
			List<Ticket> ticketList = ticketService.viewAllTickets();
			modelAndView.addObject("ticketList", ticketList);
			modelAndView.setViewName("LoggedInIndex");
			modelAndView.addObject("user", loginUser);
			session.setAttribute("user", loginUser);
		}
		else {
			modelAndView.addObject("message","Incorrect username or password, please try again");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("UserLoginPage");
			
		}
		return modelAndView;
	}
	@RequestMapping("/logoutUser")
	public ModelAndView logoutController(HttpSession session) {
		
		session.invalidate();
;
		ModelAndView modelAndView=new ModelAndView();
		List<Ticket> ticketList = ticketService.viewAllTickets();
		modelAndView.addObject("ticketList", ticketList);
		modelAndView.addObject("message", "Logout Successful");
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/DisplayAllUsers")
	public ModelAndView showAllUsersController() {
		ModelAndView modelAndView = new ModelAndView();
		List<User> userList = userService.getAllUsers();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("DisplayAllUsers");
		return modelAndView;
	}

}















