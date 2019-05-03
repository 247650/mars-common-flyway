/**
 * 
 */
package com.maximus.mars.common.flyway.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 80759
 *
 */

@SpringBootApplication
@ComponentScan("com.maximus.mars.common.flyway")
@EnableConfigurationProperties
public class FlywayBootMain 
{
	public static void main(String[] args) 
	{
		System.out.println("Starting Flyway");
		SpringApplication.run(FlywayBootMain.class, args);
	}
}
