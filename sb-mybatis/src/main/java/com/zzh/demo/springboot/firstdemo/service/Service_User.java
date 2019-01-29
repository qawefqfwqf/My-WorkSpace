package com.zzh.demo.springboot.firstdemo.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import com.zzh.demo.springboot.firstdemo.dao.Dao_User;
import com.zzh.demo.springboot.firstdemo.model.Db_User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Service_User {

	@Autowired
	private Dao_User dao_User;

	/**
	 * 列表查询
	 * 
	 * @return
	 */
	public List<Db_User> query() {
		return dao_User.findAll();
	}

	/**
	 * 根据Id查对象
	 * 
	 * @param Id
	 * @return
	 */
	public Db_User queryById(Integer id) {
		return dao_User.findOne(id);
	}

	/**
	 * 根据用户名查对象
	 * 
	 * @param Id
	 * @return
	 */
	public List<Db_User> queryByName(String username) {
		return dao_User.findByUsername(username);
	}

	/**
	 * 增
	 * 
	 * @param what
	 * @return
	 */
	public boolean add(Db_User db_User) {
		return dao_User.add(db_User) == -1 ? false : true;
	}

	@Transactional
	public boolean transactional(String username) {
		try {
			for (int i = 0; i < 5; i++) {
				Db_User db_User = Db_User.builder().username(username + i).password("123456").build();
				if (i == 4) {// 让字节数超过表中的限制大小，触发事务回滚
					db_User = db_User.toBuilder().password("1234567").build();
				}
				dao_User.add(db_User);
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
		return true;
	}

	/**
	 * 删
	 * 
	 * @param Id
	 * @return
	 */
	public boolean delete(Integer id) {
		return dao_User.delete(id) == -1 ? false : true;
	}

	/**
	 * 删除全部
	 * 
	 * @param Id
	 * @return
	 */
	public boolean deleteAll() {
		return dao_User.deleteAll() == -1 ? false : true;
	}

	/**
	 * 改
	 * 
	 * @param Id
	 * @param what
	 * @return
	 */
	public boolean update(Db_User db_User) {
		return dao_User.update(db_User) == -1 ? false : true;
	}

}
