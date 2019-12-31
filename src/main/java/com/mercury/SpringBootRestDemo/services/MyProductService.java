package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mercury.SpringBootRestDemo.beans.MyProduct;
import com.mercury.SpringBootRestDemo.daos.MyProductDao;
import com.mercury.SpringBootRestDemo.http.Response;

@Service
public class MyProductService {
	@Autowired
	private MyProductDao myProductDao;
	
	public List<MyProduct> getAll(){
		return myProductDao.findAll();
	}
	
	public Response addProduct(MyProduct product){
		myProductDao.save(product);
		return new Response(true);
	}
	
	public List<MyProduct> getAllByCateoryId(int categoryId){
		return myProductDao.getAllByCategoryId(categoryId);
	}
	
	public MyProduct getProductByProductId(int productId){
		return myProductDao.findById(productId).get();
	}
}
