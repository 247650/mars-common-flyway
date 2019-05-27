package com.maximus.mars.common.flyway.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class FlywayService 
{
	private final Log logger = LogFactory.getLog(getClass());
	
	@EnableMultiTenancyFlywayMigration
	public void testflyway()
	{
		logger.info("flyway is started.");
	}
}
