package com.zzh.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzh.entity.User;
import com.zzh.service.DeptService;
import com.zzh.service.UserService;

@Controller("userController")
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		System.out.println("进入controller");
	}

	public void getUser() {
		System.out.println(userService.getUser("1").toString());
	}

	public void addUser() {
		User user = new User();
		user.setUserName("zzh" + Math.random());
		user.setUserPwd("123456");
		user.setUserDeptId(1);
		userService.addUser(user);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("离开controller");
	}

}
