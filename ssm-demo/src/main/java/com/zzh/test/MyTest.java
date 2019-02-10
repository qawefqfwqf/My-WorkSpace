package com.zzh.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzh.controller.DeptController;
import com.zzh.controller.UserController;
import com.zzh.dao.UserMapper;
import com.zzh.entity.Dept;
import com.zzh.entity.User;
import com.zzh.service.DeptService;
import com.zzh.service.DeptService;
import com.zzh.service.UserService;
import com.zzh.service.UserService;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class MyTest {

	@Autowired
	private UserService userService;

	@Autowired
	DeptService deptService;

	@Autowired
	SqlSession sqlSession;

	@Test
	public void test() {
		Dept dept = new Dept();
		dept.setDeptName("回收部");
		deptService.addDept(dept);
	}

	@Test
	public void test2() {
		User user = new User();
		user.setUserName("zzh");
		user.setUserPwd("123456");
		user.setUserDeptId(8);
		userService.addUser(user);
	}

	@Test
	public void test3() {
		User user = userService.getUser("3");
		System.out.println(user.toString());
	}

	@Test
	public void test4() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		for (int i = 4; i < 1000; i++) {
			User user = new User();
			user.setUserName(UUID.randomUUID().toString().substring(0, 5));
			user.setUserPwd("123456");
			user.setUserDeptId(1);
			userMapper.insert(user);
		}
	}
}
