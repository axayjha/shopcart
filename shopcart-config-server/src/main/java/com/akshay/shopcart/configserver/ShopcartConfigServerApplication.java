package com.akshay.shopcart.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ShopcartConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopcartConfigServerApplication.class, args);
	}
}
