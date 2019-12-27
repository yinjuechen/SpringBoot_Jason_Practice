package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MY_DEPARTMENT")
public class MyDepartment {
	@Id
	private int id;
	@Column
	private String type;
}
