package com.zzh.action;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Parameter;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FormAction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public String execute() throws Exception {
		return ccc();

		// return bbb();

		// return aaa();
	}

	public String page() {
		return SUCCESS;
	}

	public String aaa() {
		ActionContext ac = ActionContext.getContext();

		Map<String, Parameter> map = ac.getParameters();
		for (Entry<String, Parameter> entry : map.entrySet()) {
			String key = entry.getKey();
			Parameter valueArray = entry.getValue();
			System.out.println("key:" + key + "===value:" + valueArray);
		}

		System.out.println(map.get("username"));

		return NONE;
	}

	public String bbb() {
		HttpServletRequest sac = ServletActionContext.getRequest();
		System.out.println(sac.getParameter("username"));

		return NONE;
	}

	public String ccc() {
		System.out.println(request.getParameter("username"));
		return NONE;

	}

}
