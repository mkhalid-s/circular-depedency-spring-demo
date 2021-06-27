package com.springboot.circular.depedency;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularBeanB {
	
	private String message = "Hi";
	
	private CircularBeanA circularBeanA;

	/**
	 * @return the circularBeanA
	 */
	public CircularBeanA getCircularBeanA() {
		return circularBeanA;
	}

	/**
	 * Setter Injection to handle Circular Dependency.
	 * @param circularBeanA the circularBeanA to set
	 */
	// Autowired annotation is necessary to autowire and inject beans of another dependent object.
	@Autowired
	public void setCircularBeanA(CircularBeanA circularBeanA) {
		this.circularBeanA = circularBeanA;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/*
	 * Constructor Injection
	 * public CircularBeanB(CircularBeanA beanA) { // TODO Auto-generated
	 * constructor stub this.circularBeanA = beanA; }
	 */

	/**
	 * Handling Constructor Injection with Lazy Loading during Spring context Load to prevent Circular Dependency.
	 * @param beanA
	 */
	/*
	 * public CircularBeanB(@Lazy CircularBeanA beanA) { this.circularBeanA = beanA;
	 * }
	 */
}
