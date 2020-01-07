package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INSURANCE")
public class Insurance {
	@Id
	private int id;
	@Column
	private String type;
	@Column
	private int price;
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(int id, String type, int price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
	}
	
	public Insurance(int id){
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Insurance [id=" + id + ", type=" + type + ", price=" + price + "]";
	}
	
}
