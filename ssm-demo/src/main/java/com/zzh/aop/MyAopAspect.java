package com.zzh.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAopAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {

		before();

		Object obj = arg0.proceed();
		System.out.println(obj.toString());

		after();

		return obj;

	}

	public void before() {
		System.out.println("执行前");
	}

	public void after() {
		System.out.println("执行后");
	}

}
