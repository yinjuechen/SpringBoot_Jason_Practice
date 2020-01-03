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
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(name="userid")
	private MyUser user;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zip;
	@Column
	private String driver_license;
	@Column
	private String driver_license_state;
	@Column
	private Date driver_license_expired_date;
	@Column
	private Date order_date;
	public MyApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyApplication(int id, MyUser user, String firstname, String lastname, String email, String phone,
			String address1, String address2, String city, String state, String zip, String driver_license,
			String driver_license_state, Date driver_license_expired_date, Date order_date) {
		super();
		this.id = id;
		this.user = user;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.driver_license = driver_license;
		this.driver_license_state = driver_license_state;
		this.driver_license_expired_date = driver_license_expired_date;
		this.order_date = order_date;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getDriver_license() {
		return driver_license;
	}
	public void setDriver_license(String driver_license) {
		this.driver_license = driver_license;
	}
	public String getDriver_license_state() {
		return driver_license_state;
	}
	public void setDriver_license_state(String driver_license_state) {
		this.driver_license_state = driver_license_state;
	}
	public Date getDriver_license_expired_date() {
		return driver_license_expired_date;
	}
	public void setDriver_license_expired_date(Date driver_license_expired_date) {
		this.driver_license_expired_date = driver_license_expired_date;
	}
	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "MyApplication [id=" + id + ", user=" + user + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phone=" + phone + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", driver_license=" + driver_license
				+ ", driver_license_state=" + driver_license_state + ", driver_license_expired_date="
				+ driver_license_expired_date + ", order_date=" + order_date + ", getId()=" + getId() + ", getUser()="
				+ getUser() + ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname()
				+ ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + ", getAddress1()=" + getAddress1()
				+ ", getAddress2()=" + getAddress2() + ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getZip()=" + getZip() + ", getDriver_license()=" + getDriver_license()
				+ ", getDriver_license_state()=" + getDriver_license_state() + ", getDriver_license_expired_date()="
				+ getDriver_license_expired_date() + ", getOrder_date()=" + getOrder_date() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
