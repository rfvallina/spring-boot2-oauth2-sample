package com.rfvallina.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@Configuration
@EnableAuthorizationServer
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
