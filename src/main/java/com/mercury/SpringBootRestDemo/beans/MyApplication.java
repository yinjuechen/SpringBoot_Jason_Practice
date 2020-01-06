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
@Table(name = "MY_APPLICATION")
public class MyApplication {
	@Id
	@SequenceGenerator(name = "my_application_seq", sequenceName = "MY_APPLICATION_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "my_application_seq", strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "userid")
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
	@Column
	private String creditcardnumber;
	@Column
	private String billingfirstname;
	@Column
	private String billinglastname;
	@Column
	private String billingaddress1;
	@Column
	private String billingaddress2;
	@Column
	private String billingcity;
	@Column
	private String billingstate;
	@Column
	private String billingzip;
	@Column
	private float totalprice;
	@Column
	private Date pickupdate;
	@Column
	private Date returndate;
	@Column
	private int reservedid;

	public MyApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyApplication(int id, MyUser user, String firstname, String lastname, String email, String phone,
			String address1, String address2, String city, String state, String zip, String driver_license,
			String driver_license_state, Date driver_license_expired_date, Date order_date, String creditcardnumber,
			String billingfirstname, String billinglastname, String billingaddress1, String billingaddress2,
			String billingcity, String billingstate, String billingzip, float totalprice, Date pickupdate,
			Date returndate, int reservedid) {
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
		this.creditcardnumber = creditcardnumber;
		this.billingfirstname = billingfirstname;
		this.billinglastname = billinglastname;
		this.billingaddress1 = billingaddress1;
		this.billingaddress2 = billingaddress2;
		this.billingcity = billingcity;
		this.billingstate = billingstate;
		this.billingzip = billingzip;
		this.totalprice = totalprice;
		this.pickupdate = pickupdate;
		this.returndate = returndate;
		this.reservedid = reservedid;
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

	public String getCreditcardnumber() {
		return creditcardnumber;
	}

	public void setCreditcardnumber(String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}

	public String getBillingfirstname() {
		return billingfirstname;
	}

	public void setBillingfirstname(String billingfirstname) {
		this.billingfirstname = billingfirstname;
	}

	public String getBillinglastname() {
		return billinglastname;
	}

	public void setBillinglastname(String billinglastname) {
		this.billinglastname = billinglastname;
	}

	public String getBillingaddress1() {
		return billingaddress1;
	}

	public void setBillingaddress1(String billingaddress1) {
		this.billingaddress1 = billingaddress1;
	}

	public String getBillingaddress2() {
		return billingaddress2;
	}

	public void setBillingaddress2(String billingaddress2) {
		this.billingaddress2 = billingaddress2;
	}

	public String getBillingcity() {
		return billingcity;
	}

	public void setBillingcity(String billingcity) {
		this.billingcity = billingcity;
	}

	public String getBillingstate() {
		return billingstate;
	}

	public void setBillingstate(String billingstate) {
		this.billingstate = billingstate;
	}

	public String getBillingzip() {
		return billingzip;
	}

	public void setBillingzip(String billingzip) {
		this.billingzip = billingzip;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public Date getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public int getReservedid() {
		return reservedid;
	}

	public void setReservedid(int reservedid) {
		this.reservedid = reservedid;
	}

	@Override
	public String toString() {
		return "MyApplication [id=" + id + ", user=" + user + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phone=" + phone + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", driver_license=" + driver_license
				+ ", driver_license_state=" + driver_license_state + ", driver_license_expired_date="
				+ driver_license_expired_date + ", order_date=" + order_date + ", creditcardnumber=" + creditcardnumber
				+ ", billingfirstname=" + billingfirstname + ", billinglastname=" + billinglastname
				+ ", billingaddress1=" + billingaddress1 + ", billingaddress2=" + billingaddress2 + ", billingcity="
				+ billingcity + ", billingstate=" + billingstate + ", billingzip=" + billingzip + ", totalprice="
				+ totalprice + ", pickupdate=" + pickupdate + ", returndate=" + returndate + ", reservedid="
				+ reservedid + "]";
	}

}
