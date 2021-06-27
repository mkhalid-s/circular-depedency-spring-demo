/**
 * 
 */
package com.springboot.circular.depedency;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mshaikh4
 *
 */
@Component
public class CircularBeanA {
	
	private CircularBeanB circularBeanB;

	/**
	 * @return the circularBeanB
	 */
	public CircularBeanB getCircularBeanB() {
		return circularBeanB;
	}

	/**
	 * Setter Injection to handle Circular Dependency.
	 * @param circularBeanB the circularBeanB to set
	 */
	// Autowired annotation is necessary to autowire and inject beans of another dependent object.
	@Autowired
	public void setCircularBeanB(CircularBeanB circularBeanB) {
		this.circularBeanB = circularBeanB;
	}
	
	/*
	 * public CircularBeanA(CircularBeanB beanB) { // TODO Auto-generated
	 * constructor stub this.circularBeanB = beanB; }
	 */
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Pre Destroy method invoked");
		//this.circularBeanB.setCircularBeanA(this);
	}
	
	@PostConstruct
	public void postInit() {
		System.out.println("Post Constructor method invoked");
		this.circularBeanB.setCircularBeanA(this);
	}

}
