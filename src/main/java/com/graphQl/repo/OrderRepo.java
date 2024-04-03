package com.graphQl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphQl.entity.Order;

@Repository
public interface OrderRepo  extends JpaRepository<Order, Integer>{

}
