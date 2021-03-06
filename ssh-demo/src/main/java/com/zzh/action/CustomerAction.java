package com.zzh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zzh.entity.CustomerEntity;
import com.zzh.service.CustomerService;
import com.zzh.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport {

	private CustomerService service = new CustomerServiceImpl();

	public String list() {

		List<CustomerEntity> list = service.list();
		System.out.println(list);

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", list);

		return "list";

	}
}
