package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyStatus;
import com.mercury.SpringBootRestDemo.services.MyStatusService;

@RestController
@RequestMapping("/status")
public class MyStatusController {
	@Autowired
	private MyStatusService myStatusService;
	
	@GetMapping
	public List<MyStatus> getAll(){
		return myStatusService.getAll();
	}
}
