package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.Insurance;
import com.mercury.SpringBootRestDemo.services.InsuranceService;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {
	@Autowired
	private InsuranceService insuranceService;
	
	@GetMapping
	public List<Insurance> getAll(){
		return insuranceService.getAll();
	}
	
	@GetMapping("/{id}")
	public Insurance getById(@PathVariable(name="id") int id){
		return insuranceService.getById(id);
	}
}
