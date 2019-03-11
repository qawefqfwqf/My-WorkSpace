package com.zzh.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.zzh.entity.UserEntity;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getAllUser() {
		String sql = "SELECT *  FROM dc_user order by sid desc";
		List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
		System.out.println(userList);
		return userList;
	}

	public int addUser(UserEntity user) {
		String sql = "insert into dc_user (sid,id,name,label,code,createdate) values (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, user.getSid(), user.getSid(), user.getName(), user.getLabel(), user.getCode(),
				new Date());
	}

	public int updateUser(UserEntity user) {
		String sql = "update dc_user set name =?,label=? where sid = ?";
		return jdbcTemplate.update(sql, user.getName(), user.getLabel(), user.getSid());
	}

	public int deleteUser(String id) {
		String sql = "delete from dc_user where sid = ?";
		return jdbcTemplate.update(sql, id);
	}

	/**
	 * 总是报错： java.sql.SQLException: Parameter index out of range (1 > number of parameters, which is 0).
	 * @param user
	 * @return
	 */
	public int addUserByNamedParameter(UserEntity user) {
		String sql = "insert into dc_user (sid,id,name,label,code,createdate) values (sid,:id,:name,:label,:code,:createdate)";
		user.setCreatedate(new Date());
		user.setId(user.getSid() + "");
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
		return jdbcTemplate.update(sql, sqlParameterSource);
	}
}
