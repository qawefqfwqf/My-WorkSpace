package com.zzh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zzh.entity.UserEntity;
import com.zzh.service.UserService;
import com.zzh.utils.SerializeUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * 跳转到指定映射页面，并且传递查询得数据
	 * @return
	 */
	@GetMapping
	public ModelAndView getAllUser() {
		ModelAndView mv = new ModelAndView("index");
		List<Map<String, Object>> list = service.getAllUser();
		mv.addObject("allUser", list);
		return mv;
	}

	/**
	 * 增加用户
	 */
	@PostMapping
	public boolean addUser(@RequestBody UserEntity user) {
		return service.addUser(SerializeUtil.serialize(user));
	}
	
	/**
	 * 增加用户
	 * 在经典的 JDBC 用法中, SQL 参数是用占位符 ? 表示,并且受到位置的限制. 定位参数的问题在于, 一旦参数的顺序发生变化, 就必须改变参数绑定. 
	 * 在 Spring JDBC 框架中, 绑定 SQL 参数的另一种选择是使用具名参数(named parameter).
	 * 具名参数: SQL 按名称(以冒号开头)而不是按位置进行指定. 具名参数更易于维护, 也提升了可读性. 具名参数由框架类在运行时用占位符取代
	 * 具名参数只在 NamedParameterJdbcTemplate 中得到支持。NamedParameterJdbcTemplate可以使用全部jdbcTemplate方法
	 * @param sid
	 * @param test
	 * @return
	 */
	@PostMapping("/NamedParameter")
	public boolean addUserByNamedParameter(@RequestBody UserEntity user) {
		return service.addUserByNamedParameter(SerializeUtil.serialize(user));
	}

	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@PutMapping
	public boolean updateUser(@RequestBody UserEntity user) {
		return service.updateUser(SerializeUtil.serialize(user));
	}

	/**
	 * 删除用户
	 * @param sid
	 * @return
	 */
	@DeleteMapping
	public boolean deleteUser(@RequestBody String sid) {
		return service.deleteUser(sid);
	}

	/**
	 * 事务测试：删除用户时断电
	 * @param sid
	 * @param test
	 * @return
	 */
	@GetMapping("/trans")
	public boolean deleteUser(String sid,String test) {
		return service.deleteUser(sid, test);
	}
}
