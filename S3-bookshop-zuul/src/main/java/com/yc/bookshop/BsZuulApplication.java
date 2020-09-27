package com.yc.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class BsZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsZuulApplication.class, args);
	}
}
