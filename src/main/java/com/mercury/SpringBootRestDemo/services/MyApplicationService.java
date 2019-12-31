package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Response addAppliction(MyApplication application){
		myApplicationDao.save(application);
		return new Response(true);
	}
}
