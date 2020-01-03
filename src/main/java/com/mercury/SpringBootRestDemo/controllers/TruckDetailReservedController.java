package com.mercury.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.TruckDetailReserved;
import com.mercury.SpringBootRestDemo.services.TruckDetailReservedService;

@RestController
@RequestMapping("/truckreserved")
public class TruckDetailReservedController {
	@Autowired
	private TruckDetailReservedService truckDetailReservedService;
	
	@GetMapping
	public List<TruckDetailReserved> getAll(){
		return truckDetailReservedService.getAll();
	}
	
	@PostMapping
	public TruckDetailReserved addTimeSlot(@RequestBody TruckDetailReserved t){
		return truckDetailReservedService.addTimeSlot(t);
	}
}
