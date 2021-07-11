package com.akshay.shopcart.catalogue.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.shopcart.catalogue.entity.Product;

public interface CatalogueRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAll();

	Product findById(long id);

}
