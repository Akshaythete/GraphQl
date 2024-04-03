package com.graphQl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphQl.entity.Order;
import com.graphQl.helper.ExceptionHandler;
import com.graphQl.repo.OrderRepo;
import com.graphQl.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public Order createOrder(Order order) {
		 return orderRepo.save(order);
	
	}

	@Override
	public List<Order> getAllOrder() {
		
		return orderRepo.findAll();
	}

	@Override
	public Order getSingleOrder(int id) {
		Order order = orderRepo.findById(id).orElseThrow(ExceptionHandler::throwResourceNotFoundExcpetion);
		return order;
	}

	@Override
	public Order updateOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		Order orderDelete = orderRepo.findById(id).orElseThrow(ExceptionHandler::throwResourceNotFoundExcpetion);
		orderRepo.delete(orderDelete);
		return true;
	}

}
