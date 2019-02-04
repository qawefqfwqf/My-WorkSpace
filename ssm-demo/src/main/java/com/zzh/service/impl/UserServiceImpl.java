package com.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.dao.UserDao;
import com.zzh.entity.User;
import com.zzh.service.UserService;

//@Service
public class UserServiceImpl implements UserService {

//	@Autowired
	private UserDao dao;

	public void setUserDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User getUser() {
		return dao.getUser();
	}

	@Override
	public User getUser(String name) {
		return new User(name, 0);
	}

}
