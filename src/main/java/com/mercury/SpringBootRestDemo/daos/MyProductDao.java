package com.mercury.SpringBootRestDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyProduct;

public interface MyProductDao extends JpaRepository<MyProduct, Integer>{
	List<MyProduct> getAllByCategoryId(int categoryId);
}
