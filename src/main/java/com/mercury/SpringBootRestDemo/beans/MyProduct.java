package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MY_PRODUCT")
public class MyProduct {
	@Id
	@SequenceGenerator(name="my_product_seq", sequenceName="MY_PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(generator="my_Product_seq", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private int stock;
	@Column
	private int cosumption;
	@Column
	private String category;
	@Column
	private String description;
}
