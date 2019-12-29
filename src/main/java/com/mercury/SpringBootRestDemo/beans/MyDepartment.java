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
@Table(name = "MY_DEPARTMENT")
public class MyDepartment {
	@Id
	private int id;
	@Column
	private String type;

	public MyDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyDepartment(int id, String type) {
		super();
		this.id = id;
		this.type = type;
		// this.users = users;
	}
	public MyDepartment(int id){
		super();
		this.id = id;
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
		return "MyDepartment [id=" + id + ", type=" + type + "]";
	}

}
