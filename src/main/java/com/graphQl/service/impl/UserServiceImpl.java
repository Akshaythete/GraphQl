package com.graphQl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphQl.entity.User;
import com.graphQl.helper.ExceptionHandler;
import com.graphQl.repo.UserRepo;
import com.graphQl.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User createUser(User user) {
		 return userRepo.save(user);
		
	}

	@Override
	public List<User> getAllUSer() {
	 return	userRepo.findAll();
	
	}

	@Override
	public User getSingleUser(int id) {
		
		//method refrence
		User user = userRepo.findById(id).orElseThrow(ExceptionHandler::throwResourceNotFoundExcpetion);
		return user;
	}

	@Override
	public User updateUser(int id) {
		User user = userRepo.findById(id).orElseThrow(ExceptionHandler::throwResourceNotFoundExcpetion);
		
		user.setId(user.getId());
		user.setName(user.getName());
		user.setEmail(user.getEmail());
		user.setPhone(user.getPhone());
		user.setPassword(user.getPassword());
		 
		User updatedUser = userRepo.save(user);
		
		 return updatedUser;
		
	}

	@Override
	public boolean delete(int id) {
		User user = userRepo.findById(id).orElseThrow(ExceptionHandler::throwResourceNotFoundExcpetion);
		userRepo.delete(user);
		return true;
	}

}
