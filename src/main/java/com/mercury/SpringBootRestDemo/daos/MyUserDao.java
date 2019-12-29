package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.MyUser;
import com.mercury.SpringBootRestDemo.beans.User;

public interface MyUserDao extends JpaRepository<MyUser, Integer> {

	MyUser findByEmail(String email);

}
