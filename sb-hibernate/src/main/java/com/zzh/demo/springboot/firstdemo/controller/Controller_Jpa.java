package com.zzh.demo.springboot.firstdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zzh.demo.springboot.firstdemo.model.Db_User;
import com.zzh.demo.springboot.firstdemo.service.Service_User;

@RestController
public class Controller_Jpa {

	@Autowired
	private Service_User service_user;

	/**
	 * 列表查询
	 * 
	 * @return
	 */
	@GetMapping("/jpa/query")
	public List<Db_User> query() {
		return service_user.query();
	}

	/**
	 * 根据Id查对象
	 * 
	 * @param Id
	 * @return
	 */
	@GetMapping("/jpa/queryById/{id}")
	public Db_User queryById(@PathVariable("id") Integer Id) {
		return service_user.queryById(Id);
	}

	/**
	 * 根据用户名查对象
	 * 
	 * @param Id
	 * @return
	 */
	@GetMapping("/jpa/queryByName/{username}")
	public List<Db_User> queryById(@PathVariable("username") String username) {
		return service_user.queryByName(username);
	}

	/**
	 * 增
	 * 
	 * @param what
	 * @return
	 */
	@PostMapping("/jpa/add")
	public Object add(@Valid Db_User db_User, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingResult.getFieldError().getDefaultMessage();
		}

		return service_user.add(db_User);
	}

	/**
	 * 循环增加，测试事务回滚
	 * 
	 * @param what
	 * @return
	 */
	@PostMapping("/jpa/transactional/{username}")
	public boolean transactional(@PathVariable("username") String username) {
		return service_user.transactional(username);
	}

	/**
	 * 删
	 * 
	 * @param Id
	 * @return
	 */
	@DeleteMapping("/jpa/delete/{id}")
	public boolean delete(@PathVariable("id") Integer Id) {
		return service_user.delete(Id);
	}

	/**
	 * 删除全部
	 * 
	 * @param Id
	 * @return
	 */
	@DeleteMapping("/jpa/deleteAll")
	public boolean deleteAll() {
		return service_user.deleteAll();
	}

	/**
	 * 改
	 * 
	 * @param Id
	 * @param what
	 * @return
	 */
	@PutMapping("/jpa/update")
	public Object update(@Valid Db_User db_User, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingResult.getFieldError().getDefaultMessage();
		}

		return service_user.update(db_User);
	}
}
