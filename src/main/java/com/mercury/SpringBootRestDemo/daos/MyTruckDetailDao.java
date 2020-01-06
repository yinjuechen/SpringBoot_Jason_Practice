package com.mercury.SpringBootRestDemo.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.beans.MyTruckModel;

public interface MyTruckDetailDao extends JpaRepository<MyTruckDetail, Integer>{
	List<MyTruckDetail> findAllByTruckModel(MyTruckModel modle);
	List<MyTruckDetail> findAllyByStartdateNull();
	List<MyTruckDetail> findAllByStartdateBetween(Date startdate, Date endate);
}
