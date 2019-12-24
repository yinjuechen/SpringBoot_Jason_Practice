package com.mercury.SpringBootRestDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@EnableCaching
@SpringBootApplication
public class SpringBootRestDemoApplication {

	public static void main(String[] args) {
//		foo();
//		bar();
		SpringApplication.run(SpringBootRestDemoApplication.class, args);
	}
	
//    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
//	public static void foo(){
//		System.out.println("Call foo().");
////		bar();
//	}
//    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NEVER)
//    public static void bar(){
//    	System.out.println("Call bar()");
//    	foo();
//    }

}
