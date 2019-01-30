package com.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzh.service.impl.SpringDemoServiceImpl;

@Controller
@RequestMapping("/demo")
public class SpringDemoController {

	private static Logger log = LoggerFactory.getLogger(SpringDemoController.class);

	private SpringDemoServiceImpl sdsi;

	@Autowired
	public void setSds(SpringDemoServiceImpl sdsi) {
		this.sdsi = sdsi;
	}

	@RequestMapping("/index")
	private String getPerson(String personId, Model model) {

		model.addAttribute(sdsi.getPerson());

		return "demo";
	}
}
