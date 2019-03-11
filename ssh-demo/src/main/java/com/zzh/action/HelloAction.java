package com.zzh.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

//@ParentPackage("default")
//@Action(value = "hello", results = { @Result(name = "success", type = "dispatcher", location = "/index.jsp") })
//@Namespace("/")
public class HelloAction extends ActionSupport {

	// public void say() {
	// System.out.println("===========================");
	// }

	public String test() {
		System.out.println("调用了HelloAction里面的test方法");
		return "ok";
	}
}
