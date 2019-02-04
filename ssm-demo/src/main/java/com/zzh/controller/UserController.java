package com.zzh.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzh.service.UserService;

//@Controller("userController")
public class UserController {

//	@Autowired
	private UserService service;

	public void setUserService(UserService service) {
		this.service = service;
	}

	@PostConstruct
	public void init() {
		System.out.println("����ʼ");
	}

	public void getUser() {
		System.out.println(service.getUser().toString());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("�������");
	}

}
