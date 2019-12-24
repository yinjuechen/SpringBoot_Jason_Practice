package com.mercury.SpringBootRestDemo.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution (* com.mercury.SpringBootRestDemo.controllers.*.getAll(..))") // the first * means whatever returned value
	public void log(){
		logger.info("Printing log...");
	}
}
