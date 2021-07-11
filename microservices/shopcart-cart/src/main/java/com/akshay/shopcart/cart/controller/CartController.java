package com.akshay.shopcart.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.akshay.shopcart.cart.dto.CartDTO;
import com.akshay.shopcart.cart.dto.ProductDTO;
import com.akshay.shopcart.cart.service.CartService;
//import com.netflix.client.http.HttpHeaders;

@RestController
public class CartController {
	
	@Autowired
	RestTemplate template;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CartDTO> getAll() {
		return cartService.getAllProducts();
	}
	
	@RequestMapping(value = "/getCart/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getCartItems(@RequestHeader HttpHeaders headers, HttpServletRequest request, @PathVariable Long customerId) {
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		List<CartDTO> cartItems = cartService.getCartItems(customerId);
//		System.out.println("No of items in cart: " + cartItems.size());
		List<ProductDTO> productsInCart = new ArrayList<ProductDTO>();
		for (CartDTO cartItem: cartItems) {
//			System.out.println("PRODUCT IT WANTED:" + cartItem.getProductId());
			ResponseEntity<ProductDTO> productDTO = template.exchange("http://CatalogueMS/product/"+cartItem.getProductId(), HttpMethod.GET, entity, ProductDTO.class);
			ProductDTO p = productDTO.getBody(); 
//			System.out.println("PRODUCT == NULL? " + (p == null));
//			System.out.println(p);
			productsInCart.add(p);
		}
		return productsInCart;
	}
}
