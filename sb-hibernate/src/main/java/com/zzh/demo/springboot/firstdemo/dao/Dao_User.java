package com.zzh.demo.springboot.firstdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzh.demo.springboot.firstdemo.model.Db_User;

public interface Dao_User extends JpaRepository<Db_User, Integer> {

	public List<Db_User> findByUsername(String username);

}
