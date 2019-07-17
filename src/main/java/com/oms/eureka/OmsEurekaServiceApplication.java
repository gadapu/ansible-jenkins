package com.oms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OmsEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsEurekaServiceApplication.class, args);
	}
}
