package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyDepartment;
import com.mercury.SpringBootRestDemo.daos.MyDepartmentDao;

@Service
public class MyDepartmentService {
@Autowired
private MyDepartmentDao myDepartmentDao;

public List<MyDepartment> getAll(){
	return myDepartmentDao.findAll();
}
}
