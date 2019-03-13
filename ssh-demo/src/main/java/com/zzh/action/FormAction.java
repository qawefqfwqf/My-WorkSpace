package com.zzh.action;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FormAction extends ActionSupport {

	@Override
	public String execute() throws Exception {

		ActionContext ac = ActionContext.getContext();

		Map<String, Parameter> map = ac.getParameters();
		for (Entry<String, Parameter> entry : map.entrySet()) {
			String key = entry.getKey();
			Parameter valueArray = entry.getValue();
			System.out.println("key:" + key + "===value:" + valueArray);
		}

		return NONE;
	}

	public String page() {
		return SUCCESS;
	}
}
