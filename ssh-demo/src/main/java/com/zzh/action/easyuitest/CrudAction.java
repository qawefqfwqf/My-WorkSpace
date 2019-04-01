package com.zzh.action.easyuitest;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zzh.service.impl.CrudService;

@Controller
@Scope
@Namespace("/crud")
public class CrudAction extends ActionSupport {

	@Autowired
	private CrudService service;

	@Action(value = "/index", results = { @Result(location = "/crud.html") })
	public String index() {

		return SUCCESS;
	}

	@Action(value = "/list", results = { @Result(location = "/crud.html") })
	public String list() {

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", service.list());

		return SUCCESS;
	}

	@Action(value = "/getOneById", results = { @Result(location = "/crud.html") })
	public String getOneById() {

		HttpServletRequest request = ServletActionContext.getRequest();

		Integer id = (Integer) request.getAttribute("id");

		request.setAttribute("targetOne", service.getOneById(id));

		return SUCCESS;
	}

	@Action(value = "/add", results = { @Result(location = "/crud.html") })
	public String add() {

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", service.list());

		return SUCCESS;

	}

	@Action(value = "/update", results = { @Result(location = "/crud.html") })
	public String update() {

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("result", service.list());

		return SUCCESS;
	}

	@Action(value = "/delete", results = { @Result(location = "/crud.html") })
	public String delete() {

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("result", service.list());

		return SUCCESS;
	}
}
