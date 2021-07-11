package com.akshay.shopcart.order.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akshay.shopcart.order.dto.OrderDTO;
import com.akshay.shopcart.order.entity.Order;
import com.akshay.shopcart.order.repository.OrderRepository;

@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderRepo;
	
	
	public List<Order> getAllOrders() {
		return orderRepo.findAll();			
	}

	public List<Order> getOrdersForCustomer(long customerId) {
		return orderRepo.findByCustomerId(customerId);
	}
	

}
