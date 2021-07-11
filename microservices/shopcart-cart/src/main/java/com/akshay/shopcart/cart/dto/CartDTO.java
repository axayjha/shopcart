package com.akshay.shopcart.cart.dto;

import com.akshay.shopcart.cart.entity.Cart;

public class CartDTO {
	
	private long productId;
	private long customerId;
	
	public CartDTO() {
		
	}
	
	public CartDTO(long productId, long customerId) {
		super();
		this.productId = productId;
		this.customerId = customerId;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public static CartDTO valueOf(Cart c) {
		CartDTO cartDTO = new CartDTO(c.getProductId(), c.getCustomerId());
		return cartDTO;
	}

}
