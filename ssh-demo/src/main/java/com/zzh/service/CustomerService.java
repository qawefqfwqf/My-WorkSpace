package com.zzh.service;

import java.util.List;

import com.zzh.entity.CustomerEntity;

public interface CustomerService {

	public boolean add();

	public boolean update();

	public boolean delete();

	public List<CustomerEntity> list();

}
