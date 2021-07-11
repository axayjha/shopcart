package com.akshay.shopcart.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akshay.shopcart.auth.dto.ProfileDTO;
import com.akshay.shopcart.auth.dto.UserPrincipal;
import com.akshay.shopcart.auth.entity.User;
import com.akshay.shopcart.auth.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User 404");
		}
		
		return new UserPrincipal(user);
	}
	
	


}
