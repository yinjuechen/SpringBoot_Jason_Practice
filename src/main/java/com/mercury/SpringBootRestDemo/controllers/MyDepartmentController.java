package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyDepartment;
import com.mercury.SpringBootRestDemo.services.MyDepartmentService;

@RestController
@RequestMapping("/mydepartments")
public class MyDepartmentController {
@Autowired
private MyDepartmentService myDepartmentService;

@GetMapping
public List<MyDepartment> getAll(){
	return myDepartmentService.getAll();
}
}
