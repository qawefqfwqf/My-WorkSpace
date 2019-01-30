package com.zzh.demo.springboot.firstdemo.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzh.demo.springboot.firstdemo.model.Model_Hello;
import com.zzh.demo.springboot.firstdemo.model.Prop_MyProps;
import com.zzh.demo.springboot.firstdemo.utils.Util_Time;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller_Hello {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Model_Hello hello() {
		
		Calendar c = Calendar.getInstance();

		Model_Hello demo = Model_Hello.builder().date(c.getTime().toString()).weekday(Util_Time.getWeekday_today())
				.wheather("晴天").position("公司").build();

		demo = demo.toBuilder().position("在家").build();

		return demo;
	}

}
