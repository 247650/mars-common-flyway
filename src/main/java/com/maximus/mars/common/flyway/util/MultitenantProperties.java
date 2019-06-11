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
@ConfigurationProperties(prefix = "mars.multitenant")
public class MultitenantProperties {
	private List<Database> datasources = new ArrayList<>();

	public List<Database> getDatasources() {
		return datasources;
	}

	public void setDatasources(List<Database> datasources) {
		this.datasources = datasources;
	}

	
}
