package com.akshay.shopcart.catalogue.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.shopcart.catalogue.dto.ProductDTO;
import com.akshay.shopcart.catalogue.service.CatalogueService;

@RestController
public class CatalogueController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CatalogueService catalogueService;
	
	@CrossOrigin
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	// Fetches all plan details
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProducts() {
		logger.info("Fetching all plans");
		return catalogueService.getAllProducts();
	}

	// Fetch plan details of a specific product
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getSpecificProduct(@PathVariable Integer productId) {
		System.out.println("PRODUCT ID WANTED: " + productId);
		return catalogueService.getSpecificProduct(productId);
	}

}
