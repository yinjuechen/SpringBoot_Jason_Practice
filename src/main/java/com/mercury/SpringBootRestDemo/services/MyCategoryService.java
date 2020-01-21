package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.SpringBootRestDemo.beans.MyCategory;
import com.mercury.SpringBootRestDemo.daos.MyCategoryDao;

@Service
public class MyCategoryService {
	@Autowired
	private MyCategoryDao myCategoryDao;
	
	public List<MyCategory> getAll(){
		return myCategoryDao.findAll();
	}
	
	@Transactional(isolation=Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public void updateCategory(MyCategory newMC){
		MyCategory mc = myCategoryDao.findById(newMC.getId()).get();
		mc = newMC;
		myCategoryDao.save(mc);
	}
}
