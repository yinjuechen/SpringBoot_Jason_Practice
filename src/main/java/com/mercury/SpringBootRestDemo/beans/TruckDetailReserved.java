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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TRUCKDETAIL_RESERVED")
public class TruckDetailReserved {

	@Id
	@SequenceGenerator(name = "truckdetail_reserved_seq", sequenceName = "TRUCKDETAIL_RESERVED_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "truckdetail_reserved_seq", strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "truckdetailid")
	private MyTruckDetail truckDetail;
	@Column
	private Date startdate;
	@Column
	private Date enddate;
	@Column
	private int truckmodelid;

	public TruckDetailReserved() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TruckDetailReserved(int id, MyTruckDetail truckDetail, Date startdate, Date enddate, int truckmodelid) {
		super();
		this.id = id;
		this.truckDetail = truckDetail;
		this.startdate = startdate;
		this.enddate = enddate;
		this.truckmodelid = truckmodelid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// @JsonIgnore
	public MyTruckDetail getTruckDetail() {
		return truckDetail;
	}

	// @JsonIgnore
	public void setTruckDetail(MyTruckDetail truckDetail) {
		this.truckDetail = truckDetail;
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

	public int getTruckmodelid() {
		return truckmodelid;
	}

	public void setTruckmodelid(int truckmodelid) {
		this.truckmodelid = truckmodelid;
	}

	@Override
	public String toString() {
		return "TruckDetailReserved [id=" + id + ", truckDetail=" + truckDetail + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", truckmodelid=" + truckmodelid + "]";
	}

}
