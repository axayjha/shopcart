package com.akshay.shopcart.auth.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.hibernate.sql.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.akshay.shopcart.auth.dto.AuthenticationRequest;
import com.akshay.shopcart.auth.dto.AuthenticationResponse;
import com.akshay.shopcart.auth.dto.ProfileDTO;
import com.akshay.shopcart.auth.security.JwtUtil;
import com.akshay.shopcart.auth.service.MyUserDetailsService;
import com.akshay.shopcart.auth.service.ProfileService;




@RestController
public class AuthController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@CrossOrigin
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping("/profile/{username}")
	public ProfileDTO getProfile(@PathVariable String username) throws Exception {
//		System.out.println("Trying for username: " + username);
		try {
			return profileService.getProfile(username);
		} catch (Exception e) {
			throw new Exception("User not found: ", e);
		}
	}	
	
	@GetMapping("/profileid/{profileId}")
	public ProfileDTO getProfileById(@PathVariable long profileId) throws Exception {
		try {
			return profileService.getProfileById(profileId);
		} catch (Exception e) {
			throw new Exception("User not found: ", e);
		}
	}	
}
