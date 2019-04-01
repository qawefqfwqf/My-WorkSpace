package com.zzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.dao.CrudDao;
import com.zzh.entity.User;

@Service
public class CrudService {

	@Autowired
	private CrudDao dao;

	public List<User> list() {
		return dao.list();
	}

	public User getOneById(int id) {
		return dao.getOneById(id);
	}

	public boolean add(User user) {
		return dao.add(user) > 0 ? true : false;
	}

	public boolean update(User user) {
		dao.update(user);
		return true;
	}

	public boolean delete(int id) {
		dao.delete(id);
		return true;
	}

}
