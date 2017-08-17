package com.nishant.spring.producer.producerloadbalancerclientdemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	public List<String> lst=Arrays.asList("First return value","Second return value","Third return value");
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public List<String> getAll() {
		return lst;
	}
	@RequestMapping(value="/getbyid/{id}",method=RequestMethod.GET)
	public String getById(@PathVariable Integer id) {
		return lst.get(id).toString();
	}

}
