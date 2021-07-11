package com.akshay.shopcart.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.shopcart.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByCustomerId(long customerId);
	Order findById(long id); 
	List<Order> findAll();
}
