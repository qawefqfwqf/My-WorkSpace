package com.zzh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.dao.UserDao;
import com.zzh.entity.CustomerEntity;
import com.zzh.entity.User;
import com.zzh.service.CustomerService;
import com.zzh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public List<User> list() {
		return dao.list();
	}

	@Override
	@Transactional
	public void add() {
		dao.add();
	}

	@Override
	public void update() {
	}

	@Override
	public void delete() {
		dao.delete();
	}

}
