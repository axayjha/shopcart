package com.akshay.shopcart.catalogue.dto;

import java.util.Optional;

import com.akshay.shopcart.catalogue.entity.Product;

public class ProductDTO {

	long productId;

	String productName;
	
	double productPrice;
	
	String category;
	
	double discount;

	public ProductDTO() {
		super();
	}

	public ProductDTO(long pid, String pname, double price, double discount, String category) {
		this();
		this.productId = pid;
		this.productName = pname;
		this.productPrice = price;
		this.category = category;
		this.discount = discount;
				
	}
	
	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	// Converts Entity into DTO
	public static ProductDTO valueOf(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getId());
		productDTO.setProductName(product.getName());
		productDTO.setProductPrice(product.getPrice());
		productDTO.setCategory(product.getCategory());
		productDTO.setDiscount(product.getDiscount());
		return productDTO;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + "]";
	}

}
