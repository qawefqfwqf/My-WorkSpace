package com.zzh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.dao.UserDao;
import com.zzh.entity.User;

@Service
public class UserService {

	 @Autowired
	private UserDao dao;

//	public void setUserDao(UserDao dao) {
//		this.dao = dao;
//	}

	public User getUser() {
		return dao.getUser();
	}

}
