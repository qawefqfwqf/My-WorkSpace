package com.zzh.service;

import java.util.List;

import com.zzh.entity.CustomerEntity;
import com.zzh.entity.User;

public interface UserService {

	public void add();

	public void update();

	public void delete();

	public List<User> list();

}
