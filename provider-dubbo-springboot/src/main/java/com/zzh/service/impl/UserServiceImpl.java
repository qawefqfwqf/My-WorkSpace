package com.zzh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.dao.UserDao;
import com.zzh.entity.UserEntity;
import com.zzh.service.UserService;
import com.zzh.utils.SerializeUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public List<Map<String, Object>> getAllUser() {
		return dao.getAllUser();
	}

	@Override
	public boolean addUser(byte[] user) {
		return dao.addUser((UserEntity) SerializeUtil.deserialize(user)) >= 1 ? true : false;
	}

	@Override
	public boolean updateUser(byte[] user) {
		return dao.updateUser((UserEntity) SerializeUtil.deserialize(user)) >= 1 ? true : false;
	}

	@Override
	public boolean deleteUser(String id) {
		return dao.deleteUser(id) >= 1 ? true : false;
	}

	@Override
	@Transactional
	public boolean deleteUser(String sid, String test) {
		boolean result = dao.deleteUser(sid) >= 1 ? true : false;
		int a = 1 / 0;
		return result;
	}

	@Override
	public boolean addUserByNamedParameter(byte[] user) {
		return dao.addUserByNamedParameter((UserEntity) SerializeUtil.deserialize(user)) >= 1 ? true : false;
	}

}
