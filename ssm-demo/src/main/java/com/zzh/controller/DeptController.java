package com.zzh.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzh.entity.Dept;
import com.zzh.entity.User;
import com.zzh.service.DeptService;
import com.zzh.service.UserService;

@Controller("deptController")
public class DeptController {

	@Autowired
	private DeptService deptService;

	@PostConstruct
	public void init() {
		System.out.println("进入controller");
	}

	public void addUser() {
		Dept dept = new Dept();
		dept.setDeptName("回收部");
		deptService.addDept(dept);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("离开controller");
	}

}
