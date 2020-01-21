package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyCategory;
import com.mercury.SpringBootRestDemo.services.MyCategoryService;

@RestController
@RequestMapping("/categories")
public class MyCategoryController {
	@Autowired
	private MyCategoryService myCategoryService;
	
	@GetMapping
	public List<MyCategory> getAll(){
		return myCategoryService.getAll();
	}
	
	@PutMapping
	public void updateCategory(@RequestBody MyCategory newMC){
		myCategoryService.updateCategory(newMC);
	}
}
