package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableCircuitBreaker
//@EnableWebSecurity
public class ServiceUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceUiApplication.class, args);
	}
}
