package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.Insurance;
import com.mercury.SpringBootRestDemo.beans.MyApplication;
import com.mercury.SpringBootRestDemo.daos.MyApplicationDao;
import com.mercury.SpringBootRestDemo.daos.MyUserDao;
import com.mercury.SpringBootRestDemo.http.Response;

@Service
public class MyApplicationService {
	@Autowired
	private MyApplicationDao myApplicationDao;
	@Autowired 
	private MyUserDao myUserDao;
	public List<MyApplication> getAll(){
		return myApplicationDao.findAll();
	}
	
	public MyApplication getApplicationById(int applicationId){
		return myApplicationDao.findById(applicationId).get();
	}
	public Response addAppliction(MyApplication application){
		if(application.getInsurance1() != null){
			Insurance i = new Insurance(1);
			application.setInsurance1(i);
		}
		if(application.getInsurance2() != null){
			Insurance i = new Insurance(2);
			application.setInsurance2(i);
		}
		final int userId=application.getUser().getId();
		application.setUser(myUserDao.findById(userId).get());
		System.out.println("**************" + application);
		myApplicationDao.save(application);
		return new Response(true);
	}
	
	public List<MyApplication> getAllByUserId(int userId){
		return myApplicationDao.findAllByUser(myUserDao.findById(userId).get());
	}
}
