package com.akshay.shopcart.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.shopcart.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findById(long id);
	List<Cart> findAll(); 
	List<Cart> findByCustomerId(Long customerId);
}
