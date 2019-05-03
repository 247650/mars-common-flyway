/**
 * 
 */
package com.maximus.mars.common.flyway.service;

import org.springframework.stereotype.Component;

/**
 * @author 80759
 *
 */
@Component
public class FlywayService 
{
	@EnableMultiTenancyFlywayMigration
	public String welcome() 
	{
	    return "welcome";
	}
}
