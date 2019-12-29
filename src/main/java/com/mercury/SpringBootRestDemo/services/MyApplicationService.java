package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyApplication;
import com.mercury.SpringBootRestDemo.daos.MyApplicationDao;

@Service
public class MyApplicationService {
	@Autowired
	private MyApplicationDao myApplicationDao;
	
	public List<MyApplication> getAll(){
		return myApplicationDao.findAll();
	}
}
