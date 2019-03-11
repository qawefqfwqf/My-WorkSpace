package com.zzh.service.impl;

import org.springframework.stereotype.Service;

import com.zzh.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "hello " + name + " world!";
	}

}
