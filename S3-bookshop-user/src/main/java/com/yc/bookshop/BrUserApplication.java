package com.yc.bookshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEurekaClient
// 服务降级注解
@EnableCircuitBreaker
@SpringBootApplication
@MapperScan("com.yc.bookshop.dao")
@EnableFeignClients
public class BrUserApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BrUserApplication.class, args);
	}
	
	/**
	 * 	定义 RestTemplate  Bean
	 */
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
