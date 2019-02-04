package com.zzh.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.zzh.service.UserService;
import com.zzh.service.impl.UserServiceImpl;
import com.zzh.test.MyTest;

public class MyBeanFactory {

	public static UserService getJDKProxyBean() {

		UserService userService = new UserServiceImpl();
		MyAspect ms = new MyAspect();

		UserService proxyUserService = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
				userService.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub

						ms.before();

						Object obj = method.invoke(userService, args);
						System.out.println(obj.toString());

						ms.after();

						return obj;
					}
				});

		return proxyUserService;

	}

	public static UserService getCGLIBProxyBean() {

		UserServiceImpl userService = new UserServiceImpl();
		MyAspect ms = new MyAspect();

		Enhancer e = new Enhancer();

		e.setSuperclass(userService.getClass());

		e.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				// TODO Auto-generated method stub

				ms.before();

				Object obj = arg3.invokeSuper(arg0, arg2);
				System.out.println(obj.toString());

				ms.after();

				return obj;
			}
		});

		UserService proxyUserService = (UserService) e.create();

		return proxyUserService;

	}

}
