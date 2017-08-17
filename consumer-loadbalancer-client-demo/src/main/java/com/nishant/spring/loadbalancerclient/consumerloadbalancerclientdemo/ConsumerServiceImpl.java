package com.nishant.spring.loadbalancerclient.consumerloadbalancerclientdemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ProducerClient producerClient;
	
	@HystrixCommand(fallbackMethod="getAllFallback",commandProperties= {
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="15"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="3000")
	})
	@Override
	public List<String> getAll() {
		return producerClient.getAll();
	}
	public List<String> getAllFallback() {
		return Arrays.asList("FallBackMethod return value 1","FallBackMethod return value 2","FallBackMethod return value 3");
	}

	@HystrixCommand(fallbackMethod="getByIdFallback",commandProperties= {
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="15"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="3000")
	})
	@Override
	public String getById(Integer id) {
		return producerClient.getById(id);
	}
	public String getByIdFallback(Integer id) {
		return "FallBackMethod return value :"+id;
	}

}
