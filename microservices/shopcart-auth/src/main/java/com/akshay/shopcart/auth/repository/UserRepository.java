package com.akshay.shopcart.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.shopcart.auth.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	User findById(long id);
}
