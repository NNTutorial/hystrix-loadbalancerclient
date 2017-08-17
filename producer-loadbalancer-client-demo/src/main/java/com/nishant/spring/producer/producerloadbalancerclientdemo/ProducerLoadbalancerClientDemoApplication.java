package com.nishant.spring.producer.producerloadbalancerclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerLoadbalancerClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerLoadbalancerClientDemoApplication.class, args);
	}
}
