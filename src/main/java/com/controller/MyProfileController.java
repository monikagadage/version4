package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

@Controller


public class MyProfileController {
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView userInfo(@SessionAttribute("user") User user) {

	      System.out.println("Email: " + user.getEmailId());
	      System.out.println("First Name: " + user.getFirstName());
		return new ModelAndView("user");

	      
	   }

}
