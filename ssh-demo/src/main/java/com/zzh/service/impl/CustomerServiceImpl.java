package com.zzh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zzh.entity.CustomerEntity;
import com.zzh.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

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

}
