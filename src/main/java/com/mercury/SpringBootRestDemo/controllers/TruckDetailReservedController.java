package com.mercury.SpringBootRestDemo.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.beans.TruckDetailReserved;
import com.mercury.SpringBootRestDemo.services.TruckDetailReservedService;

@RestController
@RequestMapping("/truckreserved")
public class TruckDetailReservedController {
	@Autowired
	private TruckDetailReservedService truckDetailReservedService;

	@GetMapping
	public List<TruckDetailReserved> getAll() {
		return truckDetailReservedService.getAll();
	}

	@PostMapping
	public TruckDetailReserved addTimeSlot(@RequestBody TruckDetailReserved t) {
		return truckDetailReservedService.addTimeSlot(t);
	}
	
	@GetMapping("/{id}")
	public TruckDetailReserved getById(@PathVariable(name="id") int id){
		return truckDetailReservedService.getById(id);
	}
	@GetMapping("/date/reserved/{pickUpDate}/{returnDate}")
	public List<TruckDetailReserved> getTimeSlotBetweenStartdateAndEnddate(@PathVariable(name = "pickUpDate") String pd,
			@PathVariable(name = "returnDate") String rd) throws ParseException {
		return truckDetailReservedService.getTruckSlotBetweenStartDateAndEndDate(pd, rd);
	}
	
//	@GetMapping("/date/available/{pickUpDate}/{returnDate}")
//	public List<TruckDetailReserved> getAvailableTruckBetweenStartdateAndEnddate(@PathVariable(name="pickUpDate") String pd, @PathVariable(name="returnDate") String rd) throws ParseException{
//		return truckDetailReservedService.getAvailableTrucksBetweenStartDateAndEndDate(pd, rd);
//	}
	@GetMapping("/test/{pickUpDate}/{returnDate}")
	public List<MyTruckDetail> geTruckDetails(@PathVariable(name="pickUpDate") String pd, @PathVariable(name="returnDate") String rd) throws ParseException{
		return truckDetailReservedService.findAllTruckReservedBetween(pd, rd);
	}
	@GetMapping("/amount/{modelid}/{pickUpDate}/{returnDate}")
	public void getModelCountBetweenDate(@PathVariable(name="modelid") int modelid, @PathVariable(name="pickUpDate") String pd, @PathVariable(name="returnDate") String rd) throws ParseException {
		truckDetailReservedService.getModelCountBetweenDate(modelid, pd, rd);
	}
	@GetMapping("/trucks/{id}")
	public List<TruckDetailReserved> getTruckDetailReservedByTruckDetail(@PathVariable(name="id") int truckDetailId){
		return truckDetailReservedService.getAllByTruckDetail(truckDetailId);
	}
}
