package com.zzh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class MyAutoAspect {

	public void before(JoinPoint joinPoint) {
		System.out.println("执行前 : "+joinPoint.getSignature().getName());
	}

	public void after() {
		System.out.println("执行后");
	}
	
}
