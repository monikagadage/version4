package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.model.Login;
import com.model.User;
import com.service.InterfaceUserService;



@Controller
@SessionAttributes("user,login")

public class UserController {
	
	@ModelAttribute("user")
	   public User setUpUserForm() {
	      return new User();
	   }
	@ModelAttribute("login")
	   public Login setUpForm() {
	      return new Login();
	   }

	@RequestMapping(value = "/first")
	 public ModelAndView welcome() {
	        return new ModelAndView("login-signup");
 }

	@Autowired
	private InterfaceUserService userService;
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ModelAndView saveUser(ModelAndView model,@ModelAttribute User r,HttpSession session) {
	
		int i = userService.saveUser(r);
		model.addObject("user",r);
		if(i>0)
			return new ModelAndView("login-signup");
		else 
			return null;
		}
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public ModelAndView checkLogin(ModelAndView model,@ModelAttribute User r, @ModelAttribute Login l,HttpSession session) {
		
		 Boolean check = userService.validateUser(l);
		 
		List<User> profile ;
		profile=userService.getUser(r);
		User r1=(User)profile.get(0);
		session.setAttribute("user", r1);
		 if(check) {
			
		 model.addObject("login",l);
		 return new ModelAndView("myprofile");
		 }
		 else
		 return new ModelAndView("not");

		 
	    
	  }
	 
	
}
		
	


