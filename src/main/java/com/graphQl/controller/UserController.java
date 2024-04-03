package com.graphQl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import com.graphQl.entity.User;
import com.graphQl.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@MutationMapping
	public User createUser(@Argument String name,@Argument String email, @Argument String phone,@Argument String password)
	{
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		return userService.createUser(user);
		
		
	}
	
	//get All Users
	
	@QueryMapping(name="getUsers")
	public List<User> getAllUsers()
	{
		return userService.getAllUSer();
	}
	
	//get single user
	
	@QueryMapping(name="getUser")
	public User getSingleUser(@Argument int id)
	{
		return userService.getSingleUser(id);
		
	}
	
	//delete User
	@MutationMapping
	public boolean deleteUser(@Argument int id)
	{
		return userService.delete(id);
		
	}
	

}
