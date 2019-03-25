package com.zzh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mydefault")
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	@Action(value = "/loginPage", results = { @Result(location = "/login.jsp") })
	public String loginPage() {
		return SUCCESS;
	}

	@Action(value = "/loginSub", results = {
			@Result(name = "success", location = "ognl/list", type = "redirectAction"),
			@Result(name = "error", location = "/login.jsp") })
	public String loginSub() {

		HttpServletRequest request = ServletActionContext.getRequest();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String result = "登陆失败";

		if (username.equals("zzh") && password.equals("123456")) {
			request.getSession().setAttribute("username", username);
			result = "登陆成功";
			return SUCCESS;
		} else {
			return ERROR;
		}

	}

}
