package com.akshay.shopcart.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.shopcart.auth.dto.ProfileDTO;
import com.akshay.shopcart.auth.entity.User;
import com.akshay.shopcart.auth.repository.UserRepository;

@Service
public class ProfileService {
	
	@Autowired
	private UserRepository repo;
	
	public ProfileDTO getProfile(String username) {
//		System.out.println("In service");
		User user = repo.findByUsername(username);
//		System.out.println("In service, null = " + user==null);
		ProfileDTO profileDTO = ProfileDTO.valueOf(user);
		return profileDTO;
	}
	
	public ProfileDTO getProfileById(long profileId) {
		User user = repo.findById(profileId);
		ProfileDTO profileDTO = ProfileDTO.valueOf(user);
		return profileDTO;
	}

}
