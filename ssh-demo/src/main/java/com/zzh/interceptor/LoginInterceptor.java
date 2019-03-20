package com.zzh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {

		HttpSession session = ServletActionContext.getRequest().getSession();

		Object username = session.getAttribute("username");

		if (username != null) {
			System.out.println("===================session不为空======================");
			return invocation.invoke();
		} else {
			System.out.println("===================session为空，需要登录======================");
			return "loginError";
		}
	}

}
