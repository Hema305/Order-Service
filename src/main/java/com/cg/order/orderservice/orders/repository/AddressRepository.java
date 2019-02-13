package com.cg.order.orderservice.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.order.orderservice.orders.address.Address;

public interface AddressRepository extends MongoRepository<Address, Integer>{

	List<Address> findByCustomerId(int customerId);

}
