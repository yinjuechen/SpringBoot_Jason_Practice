package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyDepartment;
import com.mercury.SpringBootRestDemo.beans.MyUser;
import com.mercury.SpringBootRestDemo.daos.MyDepartmentDao;
import com.mercury.SpringBootRestDemo.daos.MyUserDao;
import com.mercury.SpringBootRestDemo.http.Response;

@Service
public class MyUserService {
	@Autowired
	private MyUserDao myUserDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MyDepartmentDao myDepartmentDao;
	public List<MyUser> getAll(){

		return myUserDao.findAll();
	}
	
	public Response register(MyUser user){
		System.out.println("************" + user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		myUserDao.save(user);
		return new Response(true);
	}
}
