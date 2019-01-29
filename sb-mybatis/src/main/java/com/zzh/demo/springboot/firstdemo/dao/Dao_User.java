package com.zzh.demo.springboot.firstdemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zzh.demo.springboot.firstdemo.model.Db_User;

@Mapper
public interface Dao_User {
	@Select("select * from db_User")
	List<Db_User> findAll();

	@Select("select * from db_User where username= #{username}")
	List<Db_User> findByUsername(@Param("username") String username);

	@Select("select * from db_User where id = #{id}")
	Db_User findOne(@Param("id") int id);

	@Insert("INSERT INTO db_user (password, username) VALUES (#{db_User.password}, #{db_User.username})")
	int add(@Param("db_User") Db_User db_User);

	@Delete("delete from db_user where id= #{id}")
	int delete(@Param("id") int id);

	@Delete("truncate table db_user")
	int deleteAll();

	@Update("update db_user set id=#{db_User.id} , username=#{db_User.username} , password=#{db_User.password} ")
	int update(Db_User db_User);
}
