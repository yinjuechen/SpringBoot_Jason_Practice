package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="MY_PROFILE")
public class MyProfile implements GrantedAuthority{
	@Id
	private int id;
	@Column
	private String type;
	public MyProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyProfile(int id) {
		super();
		this.id = id;
	}
	public MyProfile(int id, String type) {
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
		return "MyProfile [id=" + id + ", type=" + type + "]";
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return type;
	}
	
}
