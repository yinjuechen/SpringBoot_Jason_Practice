package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity // convert this class to a Spring JPA entity. A basic operation unit in JPS.
@Table(name = "MSI_PRODUCT")
public class Product {
	@Id
	@SequenceGenerator(name = "msi_product_seq_gen", sequenceName = "MSI_PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(generator="msi_product_seq_gen", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private String brand;
	@Column
	private int price;
	@Column
	private int stock;
	@Column
	private String image;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, String brandk, int price, int stock, String image) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brandk;
		this.price = price;
		this.stock = stock;
		this.image = image;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brandk) {
		this.brand = brandk;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brandk=" + brand + ", price=" + price + ", stock=" + stock
				+ ", image=" + image + "]";
	}
	
}
