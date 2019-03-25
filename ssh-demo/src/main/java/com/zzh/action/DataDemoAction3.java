package com.zzh.action;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzh.entity.User;

public class DataDemoAction3 extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	private Map<String, User> map;

	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	public String page() {
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("username:" + user.getUsername() + "===password:" + user.getPassword());

		return NONE;
	}

	public String submit3_2() {
		for (User user : list) {
			System.out.println("username:" + user.getUsername() + "===password:" + user.getPassword());
		}

		return NONE;
	}

	public String submit3_3() {
		System.out
				.println("username:" + map.get("user").getUsername() + "===password:" + map.get("user").getPassword());

		return NONE;
	}

}
