package com.cloud;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AmateurAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmateurAdminApplication.class, args);
	}
}
