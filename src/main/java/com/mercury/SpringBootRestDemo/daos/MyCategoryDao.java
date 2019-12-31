package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyCategory;

public interface MyCategoryDao extends JpaRepository<MyCategory, Integer>{

}
