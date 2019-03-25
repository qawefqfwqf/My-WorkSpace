package com.zzh.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zzh.entity.User;
import com.zzh.service.CustomerService;
import com.zzh.service.UserService;

@Controller
@Scope("prototype")
@Namespace("user")
public class UserAction extends ActionSupport {

	@Autowired
	private UserService service;

	@Action(value = "/list", results = { @Result(location = "/userCrud.jsp") })
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", service.list());
		return SUCCESS;
	}

	@Action(value = "/add", results = { @Result(type = "redirectAction", location = "list") })
	public String add() {
		service.add();
		return SUCCESS;
	}

	@Action(value = "/delete", results = { @Result(type = "redirectAction", location = "list") })
	public String delete() {
		service.delete();
		return SUCCESS;
	}
}
