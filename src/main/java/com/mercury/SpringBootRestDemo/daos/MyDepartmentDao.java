package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyDepartment;

public interface MyDepartmentDao extends JpaRepository<MyDepartment, Integer> {

}
