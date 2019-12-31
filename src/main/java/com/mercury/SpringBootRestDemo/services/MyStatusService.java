package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mercury.SpringBootRestDemo.beans.MyStatus;
import com.mercury.SpringBootRestDemo.daos.MyStatusDao;

@Service
public class MyStatusService {
	@Autowired
	private MyStatusDao myStatusDao;
	
	public List<MyStatus> getAll(){
		return myStatusDao.findAll();
	}
	
	public MyStatus getStatusById(int id){
		return myStatusDao.findById(id).get();
	}
}
