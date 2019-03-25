package com.zzh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.dao.UserDao;
import com.zzh.entity.CustomerEntity;
import com.zzh.entity.User;
import com.zzh.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UserDao dao;

	@Override
	public List<CustomerEntity> list() {

		List<CustomerEntity> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			CustomerEntity cus = new CustomerEntity();
			cus.setId(i + 1);
			cus.setName("小明" + i);
			cus.setAddress("胡同" + i + "街");

			list.add(cus);
		}

		return list;
	}

	@Override
	public boolean add(User user) {
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
