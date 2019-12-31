package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyTruckModel;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.services.MyTruckModelService;

@RestController
@RequestMapping("/trucks")
public class MyTruckModelController {
	@Autowired
	private MyTruckModelService myProductService;
	
	@GetMapping
	public List<MyTruckModel> getAll(){
		return myProductService.getAll();
	}
	
	@GetMapping("/category/{categoryid}")
	public List<MyTruckModel> getAllByCategoryId(@PathVariable(name="categoryid") int categoryId){
		return myProductService.getAllByCateoryId(categoryId);
	}
	@PostMapping
	public MyTruckModel addProduct(@RequestBody MyTruckModel product){
		return myProductService.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public MyTruckModel getProductByProductId(@PathVariable(name="id") int productId){
		return myProductService.getProductByProductId(productId);
	}
}
