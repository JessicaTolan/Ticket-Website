package com.ticketsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ticketsystem.entity.Admin;
import com.ticketsystem.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/admin")
	public ModelAndView getLoginPageController() {
		return new ModelAndView("AdminLoginPage", "admin", new Admin());
	}
	
	@RequestMapping("/Adminlogin")
	public ModelAndView loginController(@ModelAttribute("admin") Admin admin, HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		Admin loginAdmin=adminService.getAdminByUsernameAndPassword(admin);
		if(loginAdmin!=null) {
			modelAndView.setViewName("indexAdmin");
			modelAndView.addObject("admin", loginAdmin);
			session.setAttribute("admin", loginAdmin);
		}
		else {
			modelAndView.addObject("message","Login Failed");
			modelAndView.addObject("admin", new Admin());
			modelAndView.setViewName("AdminLoginPage");
			
		}
		return modelAndView;
	}
	@RequestMapping("/logoutAdmin")
	public ModelAndView logoutController(HttpSession session) {
		
		session.invalidate();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message", "Logout Successful");
		modelAndView.addObject("admin", new Admin());
		modelAndView.setViewName("AdminLoginPage");
		return modelAndView;
	}
}
