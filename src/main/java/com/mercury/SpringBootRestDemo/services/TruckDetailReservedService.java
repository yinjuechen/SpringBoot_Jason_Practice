package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.beans.TruckDetailReserved;
import com.mercury.SpringBootRestDemo.daos.MyTruckDetailDao;
import com.mercury.SpringBootRestDemo.daos.TruckDetailReservedDao;

@Service
public class TruckDetailReservedService {
	@Autowired
	private TruckDetailReservedDao truckDetailReservedDao;
	@Autowired
	private MyTruckDetailDao myTruckDetailDao;

	public List<TruckDetailReserved> getAll() {
		return truckDetailReservedDao.findAllByOrderByStartdate();
	}
	
	public TruckDetailReserved addTimeSlot(TruckDetailReserved t){
		int tdId = t.getTruckDetail().getId();
		MyTruckDetail mtd = myTruckDetailDao.findById(tdId).get();
		System.out.println("*********************  " + mtd.getTruckTimeSlots().size());
		mtd.getTruckTimeSlots().add(t);
		t.setTruckDetail(mtd);
		return truckDetailReservedDao.save(t);
	}

}