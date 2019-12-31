package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.beans.MyTruckModel;
import com.mercury.SpringBootRestDemo.daos.MyTruckDetailDao;
import com.mercury.SpringBootRestDemo.daos.MyTruckModelDao;
import com.mercury.SpringBootRestDemo.http.Response;

@Service
public class MyTruckDetailService {
	@Autowired
	private MyTruckDetailDao myTruckDetailDao;
	@Autowired
	private MyTruckModelDao myTruckModelDao;
	
	public List<MyTruckDetail> getAll(){
		return myTruckDetailDao.findAll();
	}
	
	public List<MyTruckDetail> getAllByModelId(int modelId){
		return myTruckDetailDao.findAllByTruckModel(modelId);
	}
	
	public void addTruckDetails(MyTruckDetail truckDetails){
		int id = truckDetails.getTruckModel().getId();
		System.out.println(id);
		MyTruckModel myTruckModel = myTruckModelDao.findById(id).get();
		System.out.println(myTruckModel);
		truckDetails.setTruckModel(myTruckModel);
		System.out.println("*************** " + truckDetails);
		myTruckDetailDao.save(truckDetails);
	}
}
