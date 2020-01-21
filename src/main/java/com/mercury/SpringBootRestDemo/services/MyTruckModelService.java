package com.mercury.SpringBootRestDemo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyTruckModel;
import com.mercury.SpringBootRestDemo.daos.MyTruckModelDao;
import com.mercury.SpringBootRestDemo.daos.TruckDetailReservedDao;

@Service
public class MyTruckModelService {
	@Autowired
	private MyTruckModelDao myProductDao;
	@Autowired
	private TruckDetailReservedDao truckDetailReservedDao;

	public List<MyTruckModel> getAll() {
		return myProductDao.findAll();
	}

	public MyTruckModel addProduct(MyTruckModel product) {
		return myProductDao.save(product);
	}

	public List<MyTruckModel> getAllByCateoryId(int categoryId) {
		return myProductDao.getAllByCategoryId(categoryId);
	}

	public MyTruckModel getProductByProductId(int productId) {
		return myProductDao.findById(productId).get();
	}

	public List<MyTruckModel> getAvailableModelBetween(Date pickUpDate, Date returnDate) {
		List<MyTruckModel> res = new ArrayList<>();
		List<MyTruckModel> allModel = myProductDao.findAll();
		for (MyTruckModel model : allModel) {
			System.out.println(model.getId());
			Integer count = truckDetailReservedDao.reserverdModelCount(pickUpDate, returnDate, model.getId());
			System.out.println(count);
			if (count == null || model.getStock() > count)
				res.add(model);
		}
		return res.size() > 0 ? res : null;
	}
	
	public MyTruckModel updateTruckModelById(MyTruckModel mtm,int id){
		MyTruckModel old = myProductDao.findById(id).get();
		old = mtm;
		return myProductDao.save(old);
	}
}
