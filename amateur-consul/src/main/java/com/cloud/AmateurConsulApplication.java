package com.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class AmateurConsulApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmateurConsulApplication.class);

	@Value("${key}")
	private String key;

	@Value("${aaaa}")
	private String aaaa;

	@GetMapping("test")
	public String test(){
		LOGGER.info("调用端口8020");
		return "9999";
	}

	@GetMapping("key")
	public String key(){

		return this.key + " " + this.aaaa;
	}

	public static void main(String[] args) {
		SpringApplication.run(AmateurConsulApplication.class, args);
	}
}
