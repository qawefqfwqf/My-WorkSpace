package com.zzh.service;

import java.util.List;
import java.util.Map;

import com.zzh.entity.UserEntity;

//import javax.ws.rs.Path;

//@Path("customer")
public interface UserService {

	List<Map<String, Object>> getAllUser();

	boolean addUser(byte[] user);

	boolean updateUser(byte[] user);

	boolean deleteUser(String sid);
	
	boolean deleteUser(String sid, String test);

	boolean addUserByNamedParameter(byte[] serialize);
}
