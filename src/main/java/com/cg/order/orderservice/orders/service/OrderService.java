package com.cg.order.orderservice.orders.service;

import java.util.List;
import java.util.Optional;

import com.cg.order.orderservice.cart.Cart;
import com.cg.order.orderservice.orders.Orders;

public interface OrderService {

	List<Orders> getAllOrders();

	void placeOrder(Cart cart);


	
	
	String changeStatus(String orderStatus, int orderId);

	void deleteOrder(int orderId);

	Optional<Orders> getOrderById(int orderId);

	/* void placeOrder(Orders orders); */


	




}