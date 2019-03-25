package com.zzh.action;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzh.entity.User;

public class DataDemoAction2 extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		return aaa();

		// return bbb();

		// return aaa();
	}

	public String page() {
		return SUCCESS;
	}

	public String aaa() {

		System.out.println("username:" + user.getUsername() + "===password:" + user.getPassword());

		return NONE;
	}

}
