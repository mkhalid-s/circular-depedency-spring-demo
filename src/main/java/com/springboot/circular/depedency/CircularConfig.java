/**
 * 
 */
package com.springboot.circular.depedency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mshaikh4
 *
 */
@Configuration
@ComponentScan(basePackages =  {"com.springboot.circular.depedency"})
public class CircularConfig {

}
