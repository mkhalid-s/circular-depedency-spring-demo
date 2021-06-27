package com.springboot.circular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import com.springboot.circular.depedency.CircularBeanA;
import com.springboot.circular.depedency.CircularBeanB;
import com.springboot.circular.depedency.CircularConfig;

@SpringBootTest
@ContextConfiguration(classes = { CircularConfig.class })
class CircularDepedencySpringDemoApplicationTests {

	
	@Autowired
	ApplicationContext appContext;
	
	@Bean
	public CircularBeanA getCircularBeanA() {
		return new CircularBeanA();
	}
	
	@Bean
	public CircularBeanB getCircularBeanB() {
		return new CircularBeanB();
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void givenCircularDependency_whenConstInject_thenFails() {
		//Empty Test
	}
	
	@Test
	public void givenCircularDependency_whenSetterInject_thenPassFails() {
		CircularBeanA a = appContext.getBean(CircularBeanA.class);
		
		assertEquals("Hi", a.getCircularBeanB().getMessage());
	}

}
