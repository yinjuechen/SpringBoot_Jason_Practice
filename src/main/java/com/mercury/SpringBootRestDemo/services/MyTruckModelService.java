package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mercury.SpringBootRestDemo.beans.MyTruckModel;
import com.mercury.SpringBootRestDemo.daos.MyTruckModelDao;
import com.mercury.SpringBootRestDemo.http.Response;

@Service
public class MyTruckModelService {
	@Autowired
	private MyTruckModelDao myProductDao;
	
	public List<MyTruckModel> getAll(){
		return myProductDao.findAll();
	}
	
	public MyTruckModel addProduct(MyTruckModel product){
		return myProductDao.save(product);
	}
	
	public List<MyTruckModel> getAllByCateoryId(int categoryId){
		return myProductDao.getAllByCategoryId(categoryId);
	}
	
	public MyTruckModel getProductByProductId(int productId){
		return myProductDao.findById(productId).get();
	}
}
