package com.mercury.SpringBootRestDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.TruckDetailReserved;

public interface TruckDetailReservedDao extends JpaRepository<TruckDetailReserved, Integer> {
	List<TruckDetailReserved> findAllByOrderByStartdate();
}
