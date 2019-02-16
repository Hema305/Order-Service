package com.cg.order.orderservice.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.order.orderservice.orders.Orders;

@Repository
public interface OrderRepository extends MongoRepository<Orders, Integer>{

	List<Orders> findByCustomerId(Integer customerId);
  
    
    Orders findFirstByOrderByOrderIdDesc();

	
	

}