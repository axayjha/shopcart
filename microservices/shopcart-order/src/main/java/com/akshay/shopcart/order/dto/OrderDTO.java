package com.akshay.shopcart.order.dto;

import java.util.Date;

import com.akshay.shopcart.order.entity.Order;

public class OrderDTO {

	ProductDTO product;
	Date orderDate;
	double price;
	double discount;
	ProfileDTO seller;
	
	public ProductDTO getProduct() {
		return product;
	}




	public void setProduct(ProductDTO product) {
		this.product = product;
	}




	public Date getOrderDate() {
		return orderDate;
	}




	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public double getDiscount() {
		return discount;
	}




	public void setDiscount(double discount) {
		this.discount = discount;
	}




	public ProfileDTO getSeller() {
		return seller;
	}




	public void setSeller(ProfileDTO seller) {
		this.seller = seller;
	}




	public OrderDTO() {
		super();
	}

}
