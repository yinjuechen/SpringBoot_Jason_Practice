package com.mercury.SpringBootRestDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;

public interface MyTruckDetailDao extends JpaRepository<MyTruckDetail, Integer>{
	List<MyTruckDetail> findAllByTruckModel(int modleid);
}
