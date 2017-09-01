package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan("com.cloud.mapper")
@SpringBootApplication
public class ServiceCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCommonApplication.class, args);
	}
}
