package com.maximus.mars.common.flyway.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.flywaydb.core.Flyway;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("datasources")
public class EnableMultiTenancyFlywayMigrationImpl {

	private final Log logger = LogFactory.getLog(getClass());

	private List<Key> dataSourceList = new ArrayList<>();
	   
	public boolean migrate() {
		dataSourceList.stream().forEach(dataSource  -> {
			try {
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
				logger.info("Error flyway migration for locations" + dataSource.getLocations() );
			}
		});
		return true;
	}
	
	@Data
	public static class Key {
        private String name;
        private String url;
        private String username;
        private String password;        
        private String locations;
    }	
}
