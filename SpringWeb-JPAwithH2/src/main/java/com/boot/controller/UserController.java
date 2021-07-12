package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.boot.doa.UserRepository;
import com.boot.model.User;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String getAddUserPage()
	{
		return "index.jsp";
	}
	
//Insert
	@ResponseBody
	@PostMapping("/adduser")
	public String addUser(User user)
	{
		Optional<User> optional = userRepo.findById(user.getId());
		if(optional.isEmpty())
		{
			userRepo.save(user);
			return "Added into h2 : "+user.getName();
		}
		
		return "data not added";
	}

//Update
	@ResponseBody
	@PostMapping("/updateuser")
	public String updateUser(User user)
	{
		if(userRepo.existsById(user.getId()))
		{
			userRepo.save(user);
			return user.toString();
		}
		else
		{
			return "user does not exists";
		}
	}
	
//Delete
	@ResponseBody
	@PostMapping("deleteuser")
	public String deleteUser(@RequestParam int id)
	{
		if(userRepo.existsById(id))
		{
			userRepo.deleteById(id);;
			return "user deleted successfully";
		}
		else
		{
			return "user does not exists";
		}
	}
	
//Select
	@GetMapping("/getuser")
	public ModelAndView getUserById(@RequestParam int id, ModelAndView mv)
	{
		Optional<User> user = userRepo.findById(id);
		mv.addObject("user",user.get());
		mv.setViewName("users.jsp");
		return mv;
	}
	
	@GetMapping("/getallusers")
	public ModelAndView getAllUsers(ModelAndView mv)
	{
		List<User> users = (List<User>) userRepo.findAllSorted();
		mv.addObject("user",users);
		mv.setViewName("allusers.jsp");
		return mv;
	}
	
	@GetMapping("/getuserbyname")
	public ModelAndView getUserByName(@RequestParam String name, ModelAndView mv)
	{
		User user = userRepo.findByName(name);
		mv.addObject("user", user);
		mv.setViewName("users.jsp");
		return mv;
	}
	
	@GetMapping("getuserbyidgt")
	public ModelAndView getUserByIdGreaterThan(@RequestParam int id, ModelAndView mv)
	{
		List<User> users = userRepo.findByIdGreaterThan(id);
		mv.addObject("user",users);
		mv.setViewName("allusers.jsp");
		return mv;
	}
}
