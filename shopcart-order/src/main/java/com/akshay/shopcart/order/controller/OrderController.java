package com.akshay.shopcart.order.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.akshay.shopcart.order.dto.OrderDTO;
import com.akshay.shopcart.order.dto.ProductDTO;
import com.akshay.shopcart.order.dto.ProfileDTO;
import com.akshay.shopcart.order.entity.Order;
import com.akshay.shopcart.order.service.OrderService;

@RestController
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderService orderService;
	

	@Autowired
	RestTemplate template;

	@RequestMapping(value = "/orders", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getAllOrders(@RequestHeader HttpHeaders headers, HttpServletRequest request) {
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		List<Order> orders = orderService.getAllOrders();
//		System.out.println("ORDER SIZE: " + orders.size());
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		for (Order order: orders) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setDiscount(order.getDiscount());
			orderDTO.setPrice(order.getPrice());
			orderDTO.setOrderDate(order.getOrderDate());
			
			ResponseEntity<ProductDTO> productDTO = template.exchange("http://CatalogueMS/product/"+order.getProductId(), HttpMethod.GET, entity, ProductDTO.class);
			orderDTO.setProduct(productDTO.getBody());
//			System.out.println("PRODUCT " + productDTO.getBody());
			
//			System.out.println("SELLER ID: " + order.getSellerId());
			ResponseEntity<ProfileDTO> profileDTO = template.exchange("http://AuthMS/profileid/"+order.getSellerId(), HttpMethod.GET, entity, ProfileDTO.class);
			orderDTO.setSeller(profileDTO.getBody());
//			System.out.println(profileDTO.getBody());
			orderDTOs.add(orderDTO);			
		}
		
		return orderDTOs;
	}

	@RequestMapping(value = "/orders/{customerId}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getOrdersForCustomer(@RequestHeader HttpHeaders headers, HttpServletRequest request, @PathVariable Long customerId) {			
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			List<Order> orders =  orderService.getOrdersForCustomer(customerId);
			List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
			for (Order order: orders) {
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setDiscount(order.getDiscount());
				orderDTO.setPrice(order.getPrice());
				orderDTO.setOrderDate(order.getOrderDate());
				
				ResponseEntity<ProductDTO> productDTO = template.exchange("http://CatalogueMS/product/"+order.getProductId(), HttpMethod.GET, entity, ProductDTO.class);
				orderDTO.setProduct(productDTO.getBody());
				System.out.println("PRODUCT " + productDTO.getBody());
				
				System.out.println("SELLER ID: " + order.getSellerId());
				ResponseEntity<ProfileDTO> profileDTO = template.exchange("http://AuthMS/profileid/"+order.getSellerId(), HttpMethod.GET, entity, ProfileDTO.class);
				orderDTO.setSeller(profileDTO.getBody());
				System.out.println(profileDTO.getBody());
				orderDTOs.add(orderDTO);			
			}
			
			return orderDTOs;
	}

}
