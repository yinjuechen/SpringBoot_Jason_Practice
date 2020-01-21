package com.mercury.SpringBootRestDemo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.beans.MyTruckModel;
import com.mercury.SpringBootRestDemo.daos.MyTruckDetailDao;
import com.mercury.SpringBootRestDemo.daos.MyTruckModelDao;

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
		return myTruckDetailDao.findAllByTruckModel(myTruckModelDao.findById(modelId).get());
	}
	
	public MyTruckDetail geTruckDetailById(int id){
		return myTruckDetailDao.findById(id).get();
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
	
	public List<MyTruckDetail> getAllTrucksStartDateIsNull(){
		return myTruckDetailDao.findAllyByStartdateNull();
	}
	
	public List<MyTruckDetail> getAllTrucksStartDateBetween(Date startdate, Date enddate){
		List<MyTruckDetail> res =  myTruckDetailDao.findAllByStartdateBetween(startdate, enddate);
		res.addAll(getAllTrucksStartDateIsNull());
		return res;
		 
	}
	
	public MyTruckDetail updateTruckDetail(MyTruckDetail tr, int id){
		MyTruckDetail oldTr = myTruckDetailDao.findById(id).get();
		oldTr = tr;
		return myTruckDetailDao.save(oldTr);
	}
	
}
