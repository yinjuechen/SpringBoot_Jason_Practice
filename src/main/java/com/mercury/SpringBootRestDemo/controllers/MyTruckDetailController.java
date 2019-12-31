package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.services.MyTruckDetailService;

@RestController
@RequestMapping("/truckdetails")
public class MyTruckDetailController {
	@Autowired
	private MyTruckDetailService myTruckDetailService;

	@GetMapping
	public List<MyTruckDetail> getAll() {
		return myTruckDetailService.getAll();
	}
	@PostMapping
	public void addTruckDetails(@RequestBody MyTruckDetail truckDetail){
		 myTruckDetailService.addTruckDetails(truckDetail);
	}
	
	@GetMapping("/models/{id}")
	public List<MyTruckDetail> getAllByModelId(@PathVariable(name = "id") int modelId) {
		return myTruckDetailService.getAllByModelId(modelId);
	}
}
