package com.akshay.shopcart.auth.dto;

import com.akshay.shopcart.auth.entity.User;

public class ProfileDTO {
	private String username;
	private String name;
	private long mobile;
	private String email;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static ProfileDTO valueOf(User user) {
		ProfileDTO profile = new ProfileDTO();
		profile.setUsername(user.getUsername());
		profile.setName(user.getName());
		profile.setMobile(user.getMobile());
		profile.setEmail(user.getEmail());
		profile.setAddress(user.getAddress());
		return profile;
	}

}
