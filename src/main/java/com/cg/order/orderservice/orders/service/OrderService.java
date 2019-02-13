package com.cg.order.orderservice.orders.service;

import java.util.List;
import java.util.Optional;

import com.cg.order.orderservice.cart.Cart;
import com.cg.order.orderservice.orders.Orders;
import com.cg.order.orderservice.orders.address.Address;

public interface OrderService {

	List<Orders> getAllOrders();

	void placeOrder(Cart cart);


	
	
	String changeStatus(String orderStatus, int orderId);

	void deleteOrder(int orderId);

	List<Orders> getOrderByCustomerId(int customerId);

	void storeAddress(Address address);

	List<Address> getAddressByCustomerId(int customerId);

	//Optional<Orders> getOrderById(int orderId);

	//Optional<Orders> getOrderByCustomerId(int customerId);

	/* void placeOrder(Orders orders); */


	




}