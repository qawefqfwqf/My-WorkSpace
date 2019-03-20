package com.zzh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.zzh.entity.CustomerEntity;
import com.zzh.service.CustomerService;
import com.zzh.service.impl.CustomerServiceImpl;

@ParentPackage("mydefault")
@Namespace("ognl")
public class OgnlAction extends ActionSupport {

	private CustomerService service = new CustomerServiceImpl();

	@Action(value = "/list", results = { @Result(location = "/WEB-INF/view/ognl/ognl.jsp") })
	public String list() throws Exception {
		List<CustomerEntity> list = service.list();
		System.out.println(list);

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", list);

		return SUCCESS;
	}

	@Action(value = "/input", results = { @Result(location = "/WEB-INF/view/ognl/ognl.jsp") })
	public String input() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("username", "zzh");

		return SUCCESS;
	}

}
