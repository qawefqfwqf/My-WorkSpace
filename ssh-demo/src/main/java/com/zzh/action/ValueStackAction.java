package com.zzh.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.zzh.entity.UserEntity;

@ParentPackage("mydefault")
@Namespace("vs")
public class ValueStackAction extends ActionSupport {

	private String hello;

	public String getHello() {
		return hello;
	}

	private UserEntity user = new UserEntity();

	public UserEntity getUser() {
		return user;
	}

	private List<UserEntity> list = new ArrayList<>();

	public List<UserEntity> getList() {
		return list;
	}

	@Action(value = "/hello", results = { @Result(location = "/valueStack.jsp") })
	public String testString() {
		hello = "hello world";

		return "success";
	}

	@Action(value = "/object", results = { @Result(location = "/valueStack.jsp") })
	public String testObject() {

		user.setUsername("zzh");
		user.setPassword("123456");

		return "success";
	}

	@Action(value = "/list", results = { @Result(location = "/valueStack.jsp") })
	public String testList() {

		for (int i = 0; i < 10; i++) {
			UserEntity user = new UserEntity();
			user.setUsername("zzh");
			user.setPassword("123456");

			list.add(user);
		}

		return "success";
	}

	@Action(value = "/other", results = { @Result(location = "/valueStack.jsp") })
	public String testOther() {

		ValueStack vs = ActionContext.getContext().getValueStack();

		vs.set("setTest", "setTest");

		vs.push("pushTest");

		return "success";
	}

}
