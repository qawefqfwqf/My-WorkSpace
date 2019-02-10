package com.zzh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.dao.UserMapper;
import com.zzh.entity.Dept;
import com.zzh.entity.User;
import com.zzh.entity.UserExample;

@Service("userService")
public class UserService {

	@Autowired
	private UserMapper dao;

	/**
	 * 新增用户
	 * 
	 * @param user
	 *            用户信息
	 * @return 成功与否
	 */

	public boolean addUser(User user) {
		boolean result = false;

		if (dao.insert(user) == 1) {
			result = true;
		} else {
			System.out.println("新增用户失败：" + user.toString());
		}

		return result;
	}

	/**
	 * 根据Id查询用户
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户实体类
	 */

	public User getUser(String userId) {
		return dao.selectByPrimaryKey(Integer.parseInt(userId));
	}

	/**
	 * 根据Id查询用户及其部门信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户实体类
	 */

	public User getUserWithDept(String userId) {
		return dao.selectByPrimaryKeyWithDept(Integer.parseInt(userId));
	}

	/**
	 * 根据条件查询用户
	 * 
	 * @param example
	 *            条件
	 * @return 用户实体类集合
	 */

	public List<User> getUserList(UserExample example) {
		return dao.selectByExample(example);
	}

	/**
	 * 根据条件查询用户及其部门信息
	 * 
	 * @param example
	 *            条件
	 * @return 用户实体类集合
	 */

	public List<User> getUserListWithDept(UserExample example) {
		return dao.selectByExampleWithDept(example);
	}

}
