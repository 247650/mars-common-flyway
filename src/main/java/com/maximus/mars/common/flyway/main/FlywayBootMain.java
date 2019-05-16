/**
 * 
 */
package com.maximus.mars.common.flyway.main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.maximus.mars.common.flyway.service.FlywayService;

/**
 * @author 80759
 *
 */

@SpringBootApplication
@ComponentScan("com.maximus.mars.common.flyway")
@EnableConfigurationProperties
public class FlywayBootMain 
{
	@Autowired
	FlywayService flywayService;
	
	
	public static void main(String[] args) 
	{
		System.out.println("Starting Flyway");
		SpringApplication.run(FlywayBootMain.class, args);
	}
	
	@PostConstruct
	private void excute() {
		flywayService.migrate();
	}
}
