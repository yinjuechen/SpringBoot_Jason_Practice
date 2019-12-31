package com.mercury.SpringBootRestDemo.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MY_PRODUCT")
public class MyProduct {
	@Id
	@SequenceGenerator(name = "my_product_seq", sequenceName = "MY_PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "my_Product_seq", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String brand;
	@Column
	private int stock;
	@OneToOne
	@JoinColumn(name="categoryid")
	private MyCategory category;
	@Column
	private String image;
	@Column 
	private String model;
	@Column
	private int year;
	public MyProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyProduct(int id, String brand, int stock, MyCategory category, String image, String model, int year) {
		super();
		this.id = id;
		this.brand = brand;
		this.stock = stock;
		this.category = category;
		this.image = image;
		this.model = model;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public MyCategory getCategory() {
		return category;
	}
	public void setCategory(MyCategory category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "MyProduct [id=" + id + ", brand=" + brand + ", stock=" + stock + ", category=" + category + ", image="
				+ image + ", model=" + model + ", year=" + year + "]";
	}
	
	
}
