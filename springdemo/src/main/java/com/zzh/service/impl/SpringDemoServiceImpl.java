package com.zzh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zzh.model.PersonModel;
import com.zzh.service.inter.SpringDemoService;

public class SpringDemoServiceImpl implements SpringDemoService {

	@Override
	public PersonModel getPerson() {
		PersonModel pm = new PersonModel();

		pm.setId(1);
		pm.setName("赵昊");
		pm.setAge(28);
		pm.setWork("java programer");
		List<String> callList = new ArrayList<String>();
		callList.add("14132341341");
		callList.add("14322524322");
		callList.add("14674656655");
		callList.add("17564747474");
		pm.setCall(callList);

		return pm;
	}

}
