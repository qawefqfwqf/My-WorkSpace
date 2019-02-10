package com.zzh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.dao.DeptMapper;
import com.zzh.entity.Dept;
import com.zzh.entity.User;

@Service("deptService")
public class DeptService {

	@Autowired
	private DeptMapper dao;

	/**
	 * 新增用户
	 * 
	 * @param user
	 *            用户信息
	 * @return 成功与否
	 */

	public boolean addDept(Dept dept) {
		boolean result = false;

		int a=dao.insert(dept);
		
		if (a == 1) {
			result = true;
		} else {
			System.out.println("新增部门失败：" + dept.toString());
		}

		return result;
	}

}
