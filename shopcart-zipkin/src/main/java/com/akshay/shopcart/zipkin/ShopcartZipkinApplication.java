package com.akshay.shopcart.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ShopcartZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopcartZipkinApplication.class, args);
	}
}
