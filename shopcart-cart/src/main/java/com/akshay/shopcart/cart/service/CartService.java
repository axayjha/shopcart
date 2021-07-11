package com.akshay.shopcart.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.akshay.shopcart.cart.dto.CartDTO;
import com.akshay.shopcart.cart.entity.Cart;
import com.akshay.shopcart.cart.repository.CartRepository;

@Service
public class CartService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CartRepository cartRepo;

	
	public List<CartDTO> getAllProducts() {
		List<Cart> cart  = cartRepo.findAll();
		List<CartDTO> cartDTOs = new ArrayList<CartDTO>();
		for (Cart c: cart) {
			cartDTOs.add(CartDTO.valueOf(c));
		}
		
		return cartDTOs;
	}
	
	public List<CartDTO> getCartItems(Long customerId) {
		List<Cart> cart = cartRepo.findByCustomerId(customerId);
		List<CartDTO> cartDTOs = new ArrayList<CartDTO>();
		for (Cart c: cart) {
			cartDTOs.add(CartDTO.valueOf(c));
		}
		
		return cartDTOs;
	}
}
