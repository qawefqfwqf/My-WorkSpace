package com.zzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzh.dao.SchoolDao;
import com.zzh.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDao dao;

	public void add() {
		dao.add();
	}

	public void delete() {
		dao.delete();
	}

	public void update() {
		dao.update();
	}

}
