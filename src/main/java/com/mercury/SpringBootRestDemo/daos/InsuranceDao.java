package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.Insurance;

public interface InsuranceDao extends JpaRepository<Insurance, Integer> {

}
