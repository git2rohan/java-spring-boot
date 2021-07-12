package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

//Instead of @Controller you can also specify @RestControll
//In rest cont u don't have to specify @ResponseBody because it sends response in JSON / Specified way only
@Controller
public class WebServiceController {
	
	//Note  - Jackson converts data from type optional/string to JSON format
	//Produces - returns data into specified format
	//Consumes - accepts data into specified format
	//default produces = JSON FORMAT
	//RequestBody - used to accept raw body data from client
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping(path = "/users", produces = "application/json")
	@ResponseBody
	public Iterable<User> getUsersJSON()
	{		
		return userRepo.findAll();
	}
	
	@GetMapping(path = "/users", produces = "application/xml")
	@ResponseBody
	public Iterable<User> getUsersXML()
	{		
		return userRepo.findAll();
	}
	
	@GetMapping(path="/user/{userid}", produces = "application/json")
	@ResponseBody
	public Optional<User> getUserById(@PathVariable("userid") int userid)
	{
		return userRepo.findById(userid);
	}
	
	@GetMapping(path="/users/sorted/{order_by}" , produces = "application/json")
	@ResponseBody
	public List<User> getUsersSorted(@PathVariable("order_by") String order_by)
	{
		return userRepo.findAll(Sort.by(Sort.Direction.ASC, order_by));
	}
	
	@PostMapping(path="/user", consumes="application/json")
	@ResponseBody
	public User addUser(@RequestBody User user)
	{
		return userRepo.save(user);
	}
	
	@PutMapping(path="/user", consumes = "application/json")
	@ResponseBody
	public User saveOrUpdateUser(@RequestBody User user)
	{
		if(userRepo.existsById(user.getUserid()))
		{
			return userRepo.save(user);
		}
		return null;	
	}
	
	@DeleteMapping(path="/user/{userid}")
	@ResponseBody
	public String deleteUser(@PathVariable("userid") int userid)
	{
		if(userRepo.existsById(userid))
		{
			userRepo.deleteById(userid);
			return "User with Id : "+userid+ " deleted successfully..";
		}
		return "User with Id : "+userid+ " not found in database..";
	}
}
