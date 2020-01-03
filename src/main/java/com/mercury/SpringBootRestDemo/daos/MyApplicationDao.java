package com.mercury.SpringBootRestDemo.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyApplication;
import com.mercury.SpringBootRestDemo.beans.MyUser;

public interface MyApplicationDao extends JpaRepository<MyApplication, Integer> {
	List<MyApplication> findAllByUser(MyUser user);
}
