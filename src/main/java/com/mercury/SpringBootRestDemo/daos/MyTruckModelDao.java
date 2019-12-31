package com.mercury.SpringBootRestDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyTruckModel;

public interface MyTruckModelDao extends JpaRepository<MyTruckModel, Integer>{
	List<MyTruckModel> getAllByCategoryId(int categoryId);
}
