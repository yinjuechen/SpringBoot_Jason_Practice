package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyApplication;
import com.mercury.SpringBootRestDemo.services.MyApplicationService;

@RestController
@RequestMapping("/applications")
public class MyApplicationController {
	@Autowired
	private MyApplicationService myApplicationService;
	
	@GetMapping
	public List<MyApplication> getAll(){
		return myApplicationService.getAll();
	}
}
