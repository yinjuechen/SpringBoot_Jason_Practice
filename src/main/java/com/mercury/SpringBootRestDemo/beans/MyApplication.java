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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MY_APPLICATION")
public class MyApplication {
	@Id
	@SequenceGenerator(name="my_application_seq", sequenceName="MY_APPLICATION_SEQ", allocationSize = 1)
	@GeneratedValue(generator="my_application_seq", strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name="userid")
	private MyUser user;
	@OneToOne
	@JoinColumn(name="productid")
	private MyProduct product;
	@OneToOne
	@JoinColumn(name="statusid")
	private MyStatus status;
	@Column 
	private Date application_date;
	@OneToOne
	@JoinColumn(name="departmentid")
	private MyDepartment department;
	@Column
	private int product_qty;
	public MyApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyApplication(int id, MyUser user, MyProduct product, MyStatus status, Date application_date,
			MyDepartment department, int product_qty) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.status = status;
		this.application_date = application_date;
		this.department = department;
		this.product_qty = product_qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MyUser getUser() {
		return user;
	}
	public void setUser(MyUser user) {
		this.user = user;
	}
	public MyProduct getProduct() {
		return product;
	}
	public void setProduct(MyProduct product) {
		this.product = product;
	}
	public MyStatus getStatus() {
		return status;
	}
	public void setStatus(MyStatus status) {
		this.status = status;
	}
	public Date getApplication_date() {
		return application_date;
	}
	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}
	public MyDepartment getDepartment() {
		return department;
	}
	public void setDepartment(MyDepartment department) {
		this.department = department;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}
	@Override
	public String toString() {
		return "MyApplication [id=" + id + ", user=" + user + ", product=" + product + ", status=" + status
				+ ", application_date=" + application_date + ", department=" + department + ", product_qty="
				+ product_qty + "]";
	}
	

}
