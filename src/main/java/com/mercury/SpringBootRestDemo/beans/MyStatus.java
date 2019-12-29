package com.mercury.SpringBootRestDemo.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MY_STATUS")
public class MyStatus {
@Id
private int id;
@Column
private String status;
@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.DETACH, mappedBy="status")
private List<MyApplication> applications;
public MyStatus() {
	super();
	// TODO Auto-generated constructor stub
}
public MyStatus(int id, String status, List<MyApplication> applications) {
	super();
	this.id = id;
	this.status = status;
	this.applications = applications;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public List<MyApplication> getApplications() {
	return applications;
}
public void setApplications(List<MyApplication> applications) {
	this.applications = applications;
}
@Override
public String toString() {
	return "MyStatus [id=" + id + ", status=" + status + ", applications=" + applications + "]";
}


}
