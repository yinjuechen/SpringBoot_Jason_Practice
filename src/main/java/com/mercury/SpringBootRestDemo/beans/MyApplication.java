package com.mercury.SpringBootRestDemo.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MY_APPLICATION")
public class MyApplication {
	@Id
	@SequenceGenerator(name="my_application_seq", sequenceName="MY_APPLICATION_SEQ", allocationSize = 1)
	@GeneratedValue(generator="my_application_seq", strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinColumn(name="userid")
	@JsonIgnore
	private MyUser user;
	@Column
	private int productid;
	@Column
	private String status;
	@Column
	private Date application_date;
	@Column
	private String deparmentid;
	
}
