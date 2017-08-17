package com.nishant.spring.loadbalancerclient.consumerloadbalancerclientdemo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class ProducerClient {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	private static RestTemplate restTemplate;
	
	static {
		restTemplate=new RestTemplate();
	}

	@PostConstruct
	public String geturl() {
		return loadBalancerClient.choose("producer-loadbalancer").getUri().toString();
	}
	
	public List<String> getAll(){
		return restTemplate.getForObject(geturl()+"/producer/getall",List.class);
	}

	public String getById(Integer id) {
		return restTemplate.getForObject(geturl()+"/producer/getbyid/"+id,String.class);
	}

}
