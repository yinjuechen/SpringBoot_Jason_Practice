package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.Order;

//JPA will create an object that extends an object implements OrderDao. The created objects has all functions in JpaRepository and OrderDao.
//<T, Id> T is the @Table annotated class name, Id is the @Id annotated field's type
public interface OrderDao extends JpaRepository<Order, Integer> {

}
