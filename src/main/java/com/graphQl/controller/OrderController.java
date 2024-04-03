package com.graphQl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphQl.entity.Order;
import com.graphQl.entity.User;
import com.graphQl.service.OrderService;
import com.graphQl.service.UserService;

@Controller
public class OrderController {

	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	
	//create order
	@MutationMapping
	public Order createOrder(
			@Argument String order_details,
			@Argument String address,
			@Argument int price,
			@Argument int id)
	{
		
	
		User singleUser = userService.getSingleUser(id);
		
		Order order=new Order();
		order.setOrder_details(order_details);
		order.setAddress(address);
		order.setPrice(price);
		order.setUser(singleUser);
		
		Order createOrder = orderService.createOrder(order);
		return createOrder;
	}
	
	//get all order
	@QueryMapping
	public List<Order> getOrders()
	{
	  return orderService.getAllOrder();
	}
	
	//get single order
	@QueryMapping(name="getOrder")
	public Order getSingleOrder(@Argument int id)
	{
		 return orderService.getSingleOrder(id);
	}
	
	//delete order
	@MutationMapping
	public boolean deleteOrder(@Argument int id)
	{
		return orderService.delete(id);
	}
}
