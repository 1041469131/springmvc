package com.lx.mvc.service.impl;

import com.lx.mvc.annotation.Service;
import com.lx.mvc.service.TestService;

@Service("TestServiceImpl")
public class TestServiceImpl implements TestService {

	@Override
	public String query(String param) {

		return this.getClass().getName() + "query";
	}

	@Override
	public String insert(String param) {
		// TODO Auto-generated method stub
		return this.getClass().getName() + "insert";
	}

	@Override
	public String update(String param) {
		// TODO Auto-generated method stub
		return this.getClass().getName() + "update";
	}

}
