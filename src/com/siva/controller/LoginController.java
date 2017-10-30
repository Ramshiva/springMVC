package com.siva.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.siva.model.Login;
import com.siva.model.User;
import com.siva.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request,HttpServletRequest response)
	{
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login",new Login());
		mav.addObject("title","Login Page");
		mav.addObject("message","Please login with your Credentials");
		return mav;
	}
	
	@RequestMapping(value="/loginProcess", method= RequestMethod.POST)
	public ModelAndView validateUser(HttpServletRequest request,HttpServletResponse response,
	@ModelAttribute("login") Login login)
	{
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if(user != null)
		{
			mav = new ModelAndView("welcome");
			mav.addObject("firstName",user.getFirstName());
		}
		else
		{
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is Wrong!");
		}
		return mav;
	}
	
}
