package com.nishant.spring.loadbalancerclient.consumerloadbalancerclientdemo;

import java.util.List;

public interface ConsumerService {
	public List<String> getAll();
	public String getById(Integer id);
}
