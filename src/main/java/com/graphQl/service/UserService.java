package com.graphQl.service;

import java.util.List;

import com.graphQl.entity.User;

public interface UserService {
	
	//create user
	
	public User createUser(User user);
	
	//getAllUser
	
	public List<User> getAllUSer();
	
	//get Single User
	public User getSingleUser(int id);
	
	//update User
	public User updateUser(int id);
	
	//delete User
	public boolean delete(int id);
	

}
