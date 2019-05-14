/**
 * 
 */
package com.maximus.mars.common.flyway.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 80759
 *
 */
@Component
@ConfigurationProperties(prefix = "mars")
public class MultitenantProperties 
{
	private List<Database> databases = new ArrayList<>();
	
	

	public List<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(List<Database> databases) {
		this.databases = databases;
	}
}


