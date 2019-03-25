package com.zzh.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zzh.service.SchoolService;

@Controller
@Scope("prototype")
@ParentPackage("mydefault")
@Namespace("school")
public class SchoolAction extends ActionSupport {

	@Autowired
	private SchoolService service;

	@Action(value = "/add")
	public void add() {
		service.add();
	}

	@Action("/delete")
	public void delete() {
		service.delete();
	}

	@Action("/update")
	public void update() {
		service.update();
	}

}
