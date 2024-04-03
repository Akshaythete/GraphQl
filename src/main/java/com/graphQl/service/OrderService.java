package com.graphQl.service;

import java.util.List;

import com.graphQl.entity.Order;

public interface OrderService {
	
	
	//create order
	
	public Order createOrder(Order order);
	
	//getAll order
	
	List<Order> getAllOrder();
	
	//get single order
	
	Order getSingleOrder(int id);
	
	//update Order
	Order updateOrder(int id);
	
	//delete Order
	
	boolean delete(int id);

}
