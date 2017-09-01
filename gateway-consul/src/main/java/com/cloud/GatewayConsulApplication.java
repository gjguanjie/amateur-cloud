package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class GatewayConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayConsulApplication.class, args);
	}
}
