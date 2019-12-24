package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.SpringBootRestDemo.beans.Product;

//Rember this interface
public interface ProductDao extends JpaRepository<Product, Integer> {
	public Product findByName(String name);//select p from Product where p.name = name;
	
	@Query("select p from Product p where p.price = :price")  //Product is a jpa entity. The entire sentence is a JPQL.
    Product getByPrice(@Param("price") int price);
}
