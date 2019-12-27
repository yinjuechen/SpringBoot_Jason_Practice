package com.mercury.SpringBootRestDemo.beans;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MY_USER")
public class MyUser {
	@Id
	@SequenceGenerator(name="my_user_seq", sequenceName="MY_USER_SEQ", allocationSize = 1)
	@GeneratedValue(generator="my_user_seq", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
	@Column
	private String password;
	@OneToOne
	@JoinColumn(name = "department")
	private MyDepartment department;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
	private List<MyApplication> applications;
//	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
//	private List<MyMessage> messages;

}
