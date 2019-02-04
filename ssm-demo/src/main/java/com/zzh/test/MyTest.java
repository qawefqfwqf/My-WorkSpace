package com.zzh.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzh.aop.MyAspect;
import com.zzh.aop.MyBeanFactory;
import com.zzh.controller.UserController;
import com.zzh.entity.User;
import com.zzh.service.UserService;
import com.zzh.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class MyTest {

	/**
	 * 依赖注入控制反转
	 */
	@Test
	public void test() {

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserController uc = (UserController) app.getBean("userController");
		uc.getUser();
		app.close();

	}

	/**
	 * 面向切面AOP JDKProxy
	 */
	@Test
	public void test1() {

		UserService service = MyBeanFactory.getJDKProxyBean();
		service.getUser("zzh");

	}

	/**
	 * 面向切面AOP CGLIBProxy
	 */
	@Test
	public void test2() {

		UserService service = MyBeanFactory.getCGLIBProxyBean();
		service.getUser("zzh1");

	}

	/**
	 * 面向切面AOP 半自动
	 */
	@Test
	public void test3() {

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserService us = (UserService) app.getBean("proxyService");
		us.getUser();
		app.close();

	}
	
	/**
	 * 面向切面AOP 自动
	 */
	@Test
	public void test4() {

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		UserService us = (UserService) app.getBean("userService");
		us.getUser();
		app.close();

	}

}
