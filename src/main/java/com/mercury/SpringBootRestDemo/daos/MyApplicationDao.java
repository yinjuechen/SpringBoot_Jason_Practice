package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyApplication;

public interface MyApplicationDao extends JpaRepository<MyApplication, Integer> {

}
