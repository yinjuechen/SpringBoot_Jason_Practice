package com.mercury.SpringBootRestDemo;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@EnableCaching
@SpringBootApplication
public class SpringBootRestDemoApplication {
	@Value("${jms.broker-url}")
    private String jmsBrokerUrl;
    @Value("${jms.user}")
    private String jmsUser;
    @Value("${jms.password}")
    private String jmsPassword;
    
    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(jmsBrokerUrl);
        connectionFactory.setUserName(jmsUser);
        connectionFactory.setPassword(jmsPassword);
        return connectionFactory;
    }
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
