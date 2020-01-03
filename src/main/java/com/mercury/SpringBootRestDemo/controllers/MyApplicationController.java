package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mercury.SpringBootRestDemo.beans.MyApplication;
import com.mercury.SpringBootRestDemo.http.Response;
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
	
	@PostMapping
	public Response addApplication(@RequestBody MyApplication application){
		return myApplicationService.addAppliction(application);
	}
	
	@GetMapping("/{id}")
	public MyApplication getApplicationById(@PathVariable(name="id") int applicationId){
		return myApplicationService.getApplicationById(applicationId);
	}
	
	@GetMapping("/user/{id}")
	public List<MyApplication> getAllByUserId(@PathVariable(name="id") int userId){
		return myApplicationService.getAllByUserId(userId);
	}
}
