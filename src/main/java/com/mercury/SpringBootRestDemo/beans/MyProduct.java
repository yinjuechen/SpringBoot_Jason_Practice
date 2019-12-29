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

@Entity
@Table(name = "MY_PRODUCT")
public class MyProduct {
	@Id
	@SequenceGenerator(name = "my_product_seq", sequenceName = "MY_PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "my_Product_seq", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private int stock;
	@Column
	private int cosumption;
	@OneToOne
	@JoinColumn(name="categoryid")
	private MyCategory category;
	@Column
	private String description;
	public MyProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyProduct(int id, String name, int stock, int cosumption, MyCategory category, String description) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.cosumption = cosumption;
		this.category = category;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCosumption() {
		return cosumption;
	}
	public void setCosumption(int cosumption) {
		this.cosumption = cosumption;
	}
	public MyCategory getCategory() {
		return category;
	}
	public void setCategory(MyCategory category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MyProduct [id=" + id + ", name=" + name + ", stock=" + stock + ", cosumption=" + cosumption
				+ ", category=" + category + ", description=" + description + "]";
	}
	
	

}
