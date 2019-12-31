package com.mercury.SpringBootRestDemo.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MY_TRUCK_DETAIL")
public class MyTruckDetail {
	@Id
	@SequenceGenerator(name="my_truck_detail_seq", sequenceName = "MY_TRUCK_DETAIL_SEQ", allocationSize = 1)
	@GeneratedValue(generator="my_truck_detail_seq", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String plate;
	@Column
	private String state;
	@Column
	private String vin;
	@Column
	private int mileage;
	@Column 
	private Date startdate;
	@Column
	private Date enddate;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(name="modelid")
	private MyTruckModel truckModel;
	public MyTruckDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyTruckDetail(int id, String plate, String state, String vin, int mileage, Date startdate, Date enddate,
			MyTruckModel truckModel) {
		super();
		this.id = id;
		this.plate = plate;
		this.state = state;
		this.vin = vin;
		this.mileage = mileage;
		this.startdate = startdate;
		this.enddate = enddate;
		this.truckModel = truckModel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public MyTruckModel getTruckModel() {
		return truckModel;
	}
	public void setTruckModel(MyTruckModel truckModel) {
		this.truckModel = truckModel;
	}
	@Override
	public String toString() {
		return "MyTruckDetail [id=" + id + ", plate=" + plate + ", state=" + state + ", vin=" + vin + ", mileage="
				+ mileage + ", startdate=" + startdate + ", enddate=" + enddate + ", truckModel=" + truckModel + "]";
	}
	
	
	
}
