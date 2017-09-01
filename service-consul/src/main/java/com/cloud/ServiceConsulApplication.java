package com.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceConsulApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceConsulApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsulApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		RestTemplate rt = new RestTemplate();
		SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) rt.getRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return rt;
	}


	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;


	@GetMapping("client")
	public void test(){
		List<ServiceInstance> si = discoveryClient.getInstances("amateur-consul");
		ServiceInstance sic = loadBalancerClient.choose("amateur-consul");

		LOGGER.info("获取服务ID为{}，获取服务Uri为:{},服务host为{},服务端口为{}",sic.getServiceId() ,sic.getUri(),sic.getHost(),sic.getPort());
	}


}
