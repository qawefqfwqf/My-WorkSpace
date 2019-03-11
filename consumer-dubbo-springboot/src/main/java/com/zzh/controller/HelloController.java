package com.zzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzh.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService service;

	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		return service.sayHello(name);
	}
}
