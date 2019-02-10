package com.zzh.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	
	@Pointcut("execution(* com.zzh.service.impl.UserServiceImpl.*(..))")
	public void myPointCut(){
		
	}

	@Before("myPointCut()")
	public void before() {
		System.out.println("执行前");
	}

	@After("myPointCut()")
	public void after() {
		System.out.println("执行后");
	}
}
