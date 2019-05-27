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

<<<<<<< HEAD


	public boolean migrate() 
	{
		multitenantProperties.getDatabases().stream().forEach(dataSource  -> {
			try {
				logger.info("Starting flyway migration for locations" + dataSource.getLocation() );
				Flyway flyway = Flyway
						.configure()
=======
	public boolean migrate() {
		multitenantProperties.getDatabases().stream().forEach(dataSource -> {
			try {
				logger.info("Starting flyway migration for locations" + dataSource.getLocation());
				Flyway flyway = Flyway.configure()
>>>>>>> develop
						.dataSource(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword())
						.baselineOnMigrate(true).locations(dataSource.getLocation()).load();
				flyway.migrate();
<<<<<<< HEAD
				logger.info("Flyway migration information "+flyway.info());
				logger.info("Finished flyway migration for locations" + dataSource.getLocation() );
			} catch ( Exception e) {
				e.printStackTrace();
				logger.info("Error flyway migration for locations" + dataSource.getLocation() );
=======
				logger.info("Finished flyway migration for locations" + dataSource.getLocation());
			} catch (Exception e) {
				logger.info("----->" + e.getMessage());
				logger.info("Error flyway migration for locations" + dataSource.getLocation());
>>>>>>> develop
			}
		});
		return true;
	}

}
