package com.akshay.shopcart.catalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.shopcart.catalogue.dto.ProductDTO;
import com.akshay.shopcart.catalogue.entity.Product;
import com.akshay.shopcart.catalogue.repository.CatalogueRepository;

@Service
public class CatalogueService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CatalogueRepository catalogueRepo;

	// Fetches all product details
	public List<ProductDTO> getAllProducts() {

		List<Product> products = catalogueRepo.findAll();
		List<ProductDTO> catalogueDTOs = new ArrayList<ProductDTO>();

		for (Product product : products) {
			ProductDTO catalogueDTO = ProductDTO.valueOf(product);
			catalogueDTOs.add(catalogueDTO);
		}

		logger.info("Product details : {}", catalogueDTOs);
		return catalogueDTOs;
	}

	// Fetch specific product details
	public ProductDTO getSpecificProduct(int productId) {
		logger.info("Product details : {}", productId);
		return ProductDTO.valueOf(catalogueRepo.findById(productId));
	}

}
