package com.zzh.demo.springboot.firstdemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzh.demo.springboot.firstdemo.model.Db_User;
import com.zzh.demo.springboot.firstdemo.service.Service_User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private Service_User service_User;

	@Test
	public void findByName() {
		Db_User db_User = service_User.queryById(1004);
		
		System.out.println(db_User.toString());

//		Assert.assertEquals(new String("曾智辉"), db_User.getUsername());

	}
}
