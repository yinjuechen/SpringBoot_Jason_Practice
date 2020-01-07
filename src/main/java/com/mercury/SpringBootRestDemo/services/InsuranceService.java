package com.mercury.SpringBootRestDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRestDemo.beans.Insurance;
import com.mercury.SpringBootRestDemo.daos.InsuranceDao;

@Service
public class InsuranceService {
	@Autowired
	private InsuranceDao insuranceDao;
	
	public List<Insurance> getAll(){
		return insuranceDao.findAll();
	}
	
	public Insurance getById(int id){
		return insuranceDao.findById(id).get();
	}
}
