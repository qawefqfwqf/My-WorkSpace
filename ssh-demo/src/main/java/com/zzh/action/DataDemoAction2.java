package com.zzh.action;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzh.entity.UserEntity;

public class DataDemoAction2 extends ActionSupport implements ModelDriven<UserEntity> {

	private UserEntity user = new UserEntity();

	@Override
	public UserEntity getModel() {
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
