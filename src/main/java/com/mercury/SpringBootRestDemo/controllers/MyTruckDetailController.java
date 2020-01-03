package com.mercury.SpringBootRestDemo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
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
	public void addTruckDetails(@RequestBody MyTruckDetail truckDetail) {
		myTruckDetailService.addTruckDetails(truckDetail);
	}

	@GetMapping("/models/{id}")
	public List<MyTruckDetail> getAllByModelId(@PathVariable(name = "id") int modelId) {
		return myTruckDetailService.getAllByModelId(modelId);
	}

	@GetMapping("/startdate")
	public List<MyTruckDetail> getAllTrucksStartDateIsNull() {
		return myTruckDetailService.getAllTrucksStartDateIsNull();
	}

	@GetMapping("/date/{startdate}/{enddate}")
	public List<MyTruckDetail> getAllTrucksStartDateBetween(@PathVariable(name = "startdate") String startdate,
			@PathVariable(name = "enddate") String enddate) throws ParseException {
		return myTruckDetailService.getAllTrucksStartDateBetween(new SimpleDateFormat("yyyy-MM-dd").parse(startdate),
				new SimpleDateFormat("yyyy-MM-dd").parse(enddate));
	}
}
