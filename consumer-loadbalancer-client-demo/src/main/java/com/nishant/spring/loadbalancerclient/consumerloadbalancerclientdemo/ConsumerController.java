package com.nishant.spring.loadbalancerclient.consumerloadbalancerclientdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public List<String> getAll(){
		List<String> lst=consumerService.getAll();
		return lst;
	}
	
	@RequestMapping(value="/getbyid/{id}",method=RequestMethod.GET)
	public String getById(@PathVariable Integer id){
		String result=consumerService.getById(id);
		return result;
	}

}
