package com.akshay.shopcart.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akshay.shopcart.cart.dto.User;
import com.akshay.shopcart.cart.dto.UserPrincipal;





@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		
		return new UserPrincipal(user);
	}

}
