package com.zzh.service;

import java.util.List;

import com.zzh.entity.CustomerEntity;
import com.zzh.entity.User;

public interface CustomerService {

	public boolean add(User user);

	public boolean update(User user);

	public boolean delete(int id);

	public List<CustomerEntity> list();

}
