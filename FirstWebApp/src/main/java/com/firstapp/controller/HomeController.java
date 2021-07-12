package com.firstapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.firstapp.bean.User;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public ModelAndView getHome(User user, HttpSession session, ModelAndView  mv)
	{
		mv.addObject("user",user);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("profile")
	public ModelAndView getProfile(@RequestParam("userId") String userId, ModelAndView mv)
	{
		mv.addObject("id", userId);
		mv.setViewName("profile");
		return mv;
	}
	
	
}
