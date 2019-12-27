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

@Entity
@Table(name="MY_MESSAGE")
public class MyMessage {
	@Id
	@SequenceGenerator(name="my_message_seq", sequenceName="MY_MESSAGE_SEQ", allocationSize = 1)
	@GeneratedValue(generator="my_message_seq", strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String content;
	@Column
	private Date sentdate;
//	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
//	@JoinColumn(name="userid")
//	private MyUser user;
}
