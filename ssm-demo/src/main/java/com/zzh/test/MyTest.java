package com.zzh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzh.controller.UserController;

public class MyTest {

	@org.junit.Test
	public void test() {

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserController uc = (UserController) app.getBean("userController");
		uc.getUser();
		app.close();
		
	}
}
