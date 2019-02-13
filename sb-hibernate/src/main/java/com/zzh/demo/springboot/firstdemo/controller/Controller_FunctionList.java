package com.zzh.demo.springboot.firstdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzh.demo.springboot.firstdemo.model.Prop_Function;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller_FunctionList {
	
	@Autowired
	private Prop_Function myProps_prop;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Prop_Function functionList() {
		return myProps_prop;
	}
}
