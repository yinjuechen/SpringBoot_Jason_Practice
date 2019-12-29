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
import com.mercury.SpringBootRestDemo.beans.MyProduct;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.services.MyProductService;

@RestController
@RequestMapping("/myproducts")
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	
	@GetMapping
	public List<MyProduct> getAll(){
		return myProductService.getAll();
	}
	
	@GetMapping("/category/{categoryid}")
	public List<MyProduct> getAllByCategoryId(@PathVariable(name="categoryid") int categoryId){
		return myProductService.getAllByCateoryId(categoryId);
	}
	@PostMapping
	public Response addProduct(@RequestBody MyProduct product){
		return myProductService.addProduct(product);
	}
}
