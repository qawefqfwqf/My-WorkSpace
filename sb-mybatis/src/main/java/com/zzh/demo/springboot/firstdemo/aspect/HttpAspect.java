package com.zzh.demo.springboot.firstdemo.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class HttpAspect {

	@Pointcut("execution(public * com.zzh.demo.springboot.firstdemo.controller.*.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = attributes.getRequest();

		log.info("Request report ----------- " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				+ " --------------------------------");
		log.info("Url         : " + req.getMethod() + " " + req.getRequestURL());
		log.info("Controller  : " + joinPoint.getSignature().getDeclaringTypeName());
		log.info("Method      : " + joinPoint.getSignature().getName());
		log.info("Para        : " + joinPoint.getArgs());
		log.info("--------------------------------------------------------------------------------");
	}

	@AfterReturning(pointcut = "log()", returning = "obj")
	public void doAfterReturning(Object obj) {
		log.info("Response report ----------- " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				+ " --------------------------------");
		log.info("return   : " + obj);
		log.info("--------------------------------------------------------------------------------");
	}
}
