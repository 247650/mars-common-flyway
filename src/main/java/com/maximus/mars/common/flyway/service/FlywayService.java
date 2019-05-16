package com.maximus.mars.common.flyway.service;

import org.springframework.stereotype.Component;

@Component
public class FlywayService 
{
	@EnableMultiTenancyFlywayMigration
	public void migrate()
	{
		System.out.println("In Flyway test method");
	}
}
