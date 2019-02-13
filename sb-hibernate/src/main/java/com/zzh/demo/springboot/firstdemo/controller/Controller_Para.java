package com.zzh.demo.springboot.firstdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/para")
public class Controller_Para {

	@GetMapping("/pathvar/{id}")
	public String pathvar(@PathVariable("id")String id) {
		return "得到了参数："+id;
	}
	
	@GetMapping("/default")
	public String deFault(@RequestParam(value="id",required=false,defaultValue="0")String id) {
		return "得到了参数："+id;
	}
}
