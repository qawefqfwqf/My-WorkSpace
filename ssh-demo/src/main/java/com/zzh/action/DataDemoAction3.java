package com.zzh.action;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzh.entity.UserEntity;

public class DataDemoAction3 extends ActionSupport {

	private UserEntity user;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	private List<UserEntity> list;

	public List<UserEntity> getList() {
		return list;
	}

	public void setList(List<UserEntity> list) {
		this.list = list;
	}

	private Map<String, UserEntity> map;

	public Map<String, UserEntity> getMap() {
		return map;
	}

	public void setMap(Map<String, UserEntity> map) {
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
		for (UserEntity user : list) {
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
