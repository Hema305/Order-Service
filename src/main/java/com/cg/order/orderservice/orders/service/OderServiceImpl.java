package com.cg.order.orderservice.orders.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.order.orderservice.cart.Cart;
import com.cg.order.orderservice.cart.Items;
import com.cg.order.orderservice.orders.Orders;
import com.cg.order.orderservice.orders.address.Address;
import com.cg.order.orderservice.orders.repository.AddressRepository;
import com.cg.order.orderservice.orders.repository.OrderRepository;

@Service
public class OderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private static int orderId = 1;
	int customerId;

	@Override
	public List<Orders> getAllOrders() {

		return orderRepository.findAll();

	}

	
	@Override public void placeOrder(Cart cart) {
	      int totalquantity = 0;
	      customerId=cart.getCartId();
	      Orders orders = new Orders();
	     
	      orders.setAddress(orders.getAddress());
	      orders.setAmmountPaid(cart.getTotalPrice());;
	      orders.setCustomerId(cart.getCartId()); 
	    
	      orders.setModeOfPayment("card");
	      orders.setOrderStatus("deliverd");
	      List<Items> items =  cart.getItems();
	      for (Items item : items) {
	    	  totalquantity = totalquantity + item.getQuantity();
	      }
	      orders.setQuantity(totalquantity);
	      orders.setOrderDate(LocalDate.now());
	     
	      orders.setOrderId(orderId++); System.out.println(orders.getOrderId());
	      orderRepository.save(orders);
	     
	     
	      }
	 
	/*
	 * @Override public void placeOrder(Orders orders) {
	 * orders.setOrderId(orderId++); orderRepository.save(orders); }
	 */
	


	
	/*
	 * @Override public Optional<Orders> getOrderById(int orderId) {
	 * 
	 * return orderRepository.findById(orderId); }
	 */
	 

	/*
	 * Optional<Orders> optional = orderService.getAccountById(orderId); Orders
	 * orders = optional.get(); orders.setOrderStatus(orderStatus);
	 */
	@Override
	public String changeStatus(@RequestParam String orderStatus, @PathVariable int orderId) {
		Orders order = orderRepository.findById(orderId).get();
		order.setOrderStatus(orderStatus);
		orderRepository.save(order);
		return orderStatus;

	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);

	}


	
	  @Override public List<Orders> getOrderByCustomerId(int customerId) {
	  
	  return orderRepository.findByCustomerId(customerId); 
	  }


	@Override
	public void storeAddress(Address address) {
		
		addressRepository.save(address);
		
	}


	@Override
	public List<Address> getAddressByCustomerId(int customerId) {
		
		return addressRepository.findByCustomerId(customerId);
	}
	 

}
