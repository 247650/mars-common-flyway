package com.maximus.mars.common.flyway.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.maximus.mars.common.flyway.util.MultitenantProperties;

@Component
@ConfigurationProperties("datasources")
public class EnableMultiTenancyFlywayMigrationImpl {

	private final Log logger = LogFactory.getLog(getClass());

	private MultitenantProperties multitenantProperties;
	
	@Autowired   
	public void setMultitenantProperties(MultitenantProperties multitenantProperties) {
		this.multitenantProperties = multitenantProperties;
	}



	public boolean migrate() 
	{
		System.out.println("Inside EnableMultiTenancyFlywayMigrationImpl.migrate() method");
		multitenantProperties.getDatabases().stream().forEach(dataSource  -> {
			try {
				System.out.println("DataSource =>A ===> +" + dataSource.getUrl());
				System.out.println("DataSource =>A ===> +" + dataSource.getUsername());
				System.out.println("DataSource =>A ===> +" + dataSource.getPassword());
				logger.info("Starting flyway migration for locations" + dataSource.getLocations() );
				Flyway flyway = Flyway
						.configure()
						.dataSource(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword())
						.baselineOnMigrate(true)
						.locations(dataSource.getLocations())
						.load();
				flyway.migrate();
				logger.info("Finished flyway migration for locations" + dataSource.getLocations() );
			} catch ( Exception e) {
				e.printStackTrace();
				logger.info("Error flyway migration for locations" + dataSource.getLocations() );
			}
		});
		return true;
	}
	
}
