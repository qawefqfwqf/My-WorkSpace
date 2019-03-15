package com.zzh.action;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DataDemoAction extends ActionSupport {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("username:" + username + "===password:" + password);

		return NONE;
	}

	public String page() {
		return SUCCESS;
	}
}
