package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyStatus;

public interface MyStatusDao extends JpaRepository<MyStatus, Integer>{

}
