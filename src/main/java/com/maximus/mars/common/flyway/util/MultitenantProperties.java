/**
 * 
 */
package com.maximus.mars.common.flyway.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 80759
 *
 */
@Component
@ConfigurationProperties(prefix = "mars.mutitenancy")
public class MultitenantProperties {
	private final Log logger = LogFactory.getLog(getClass());
	private List<Database> datasources = new ArrayList<>();

	public List<Database> getDatasources() {
		return datasources;
	}

	public void setDatasources(List<Database> datasources) {
		this.datasources = datasources;
	}

	
}
