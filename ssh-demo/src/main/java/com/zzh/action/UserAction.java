package com.zzh.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private String name;

	public String getName() {
		return name;
	}

	public String find() {
		name = "zzh";

		return SUCCESS;
	}

	public String add() {
		return SUCCESS;
	}

	public String update() {
		return SUCCESS;
	}

	public String delete() {
		return SUCCESS;
	}

}
