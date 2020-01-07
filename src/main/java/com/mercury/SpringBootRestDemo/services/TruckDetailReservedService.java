package com.mercury.SpringBootRestDemo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.beans.TruckDetailReserved;
import com.mercury.SpringBootRestDemo.daos.MyTruckDetailDao;
import com.mercury.SpringBootRestDemo.daos.MyTruckModelDao;
import com.mercury.SpringBootRestDemo.daos.TruckDetailReservedDao;

@Service
public class TruckDetailReservedService {
	@Autowired
	private TruckDetailReservedDao truckDetailReservedDao;
	@Autowired
	private MyTruckDetailDao myTruckDetailDao;
	@Autowired
	private MyTruckModelDao myTruckModelDao;

	public List<TruckDetailReserved> getAll() {
		return truckDetailReservedDao.findAllByOrderByStartdate();
	}
	
	public TruckDetailReserved getById(int id){
		return truckDetailReservedDao.findById(id).get();
	}
	
	@Transactional(isolation=Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public TruckDetailReserved addTimeSlot(TruckDetailReserved t){
//		int tdId = t.getTruckDetail().getId();
//		MyTruckDetail mtd = myTruckDetailDao.findById(tdId).get();
		List<MyTruckDetail> truckByModel = myTruckDetailDao.findAllByTruckModel(myTruckModelDao.findById(t.getTruckmodelid()).get());
		Collections.sort(truckByModel);
		List<MyTruckDetail> rst = truckDetailReservedDao.findAllTruckReservedBetween(t.getStartdate(), t.getEnddate());
		for(MyTruckDetail mtd : truckByModel){
			if(!rst.contains(mtd)){
				mtd.getTruckTimeSlots().add(t);
				t.setTruckDetail(mtd);
				return truckDetailReservedDao.save(t);
			}
		}
		return null;
//		if(rst.contains(mtd))
//			return null;
//		System.out.println("*********************  " + mtd.getTruckTimeSlots().size());
//		mtd.getTruckTimeSlots().add(t);
//		t.setTruckDetail(mtd);
//		return truckDetailReservedDao.save(t);
	}
	
	public List<TruckDetailReserved> getTruckSlotBetweenStartDateAndEndDate(String pickUpDate, String returnDate) throws ParseException{
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(pickUpDate);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
		return truckDetailReservedDao.findAllByStartdateBetweenOrEnddateBetween(startDate, endDate, startDate, endDate);
	}
//	public List<TruckDetailReserved> getAvailableTrucksBetweenStartDateAndEndDate(String pickUpDate, String returnDate) throws ParseException{
//		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(pickUpDate);
//		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
//		return truckDetailReservedDao.findAllByStartdateAfterOrEnddateBefore(endDate, startDate);
//	}
//	
	public List<MyTruckDetail> findAllTruckReservedBetween(String pickUpdate, String returnDate) throws ParseException{
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(pickUpdate);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
		List<MyTruckDetail> tmp = truckDetailReservedDao.findAllTruckReservedBetween(startDate, endDate);
		tmp.forEach(e -> System.out.println(e.getTruckTimeSlots().size()));
		return tmp;
	}
	
	public void getModelCountBetweenDate(int modelid, String pickUpDate, String returnDate) throws ParseException{
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(pickUpDate);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
		int amount = truckDetailReservedDao.reserverdModelCount(startDate, endDate, modelid);
		System.out.println("$$$$$$$$$$$$$$$$$$$  " + amount);
	}

}