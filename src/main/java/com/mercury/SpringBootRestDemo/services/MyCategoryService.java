package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyCategory;
import com.mercury.SpringBootRestDemo.daos.MyCategoryDao;

@Service
public class MyCategoryService {
	@Autowired
	private MyCategoryDao myCategoryDao;
	
	public List<MyCategory> getAll(){
		return myCategoryDao.findAll();
	}
}
