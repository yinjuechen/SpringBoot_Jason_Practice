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
private String type;
public MyStatus() {
	super();
	// TODO Auto-generated constructor stub
}
public MyStatus(int id, String type) {
	super();
	this.id = id;
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "MyStatus [id=" + id + ", type=" + type + "]";
}


}
