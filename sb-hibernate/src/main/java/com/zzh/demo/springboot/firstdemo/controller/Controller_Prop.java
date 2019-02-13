package com.zzh.demo.springboot.firstdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzh.demo.springboot.firstdemo.model.Prop_MyProps;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@Slf4j
public class Controller_Prop {

	// 引用属性文件属性 方式1
	@Value("${myProps.simpleProp}")
	private String simpleProp;

	// 引用属性文件属性 方式2
	@Autowired
	private Prop_MyProps myProps_prop;

	@RequestMapping(value = "/prop", method = RequestMethod.GET)
	public Prop_MyProps propDemo() {

		System.out.println("引用属性文件方式一：" + simpleProp);

		System.out.println("引用属性文件方式二：" + myProps_prop.toString());

		return myProps_prop;
	}
}
