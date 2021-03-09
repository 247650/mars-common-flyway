package com.maximus.mars.common.flyway.service;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.maximus.mars.common.credentials.service.CredentialsService;
import com.maximus.mars.common.credentials.vo.MarsDBSecret;
import com.maximus.mars.common.flyway.util.MultitenantProperties;


@Component
@ConfigurationProperties("datasources")
public class EnableMultiTenancyFlywayMigrationImpl {

	private static final Logger logger = LoggerFactory.getLogger(EnableMultiTenancyFlywayMigrationImpl.class);

	private MultitenantProperties multitenantProperties;

	private CredentialsService credentialService;

	@Value("${mars.flyway.out-of-order:false}")
	private Boolean outOfOrder;

	@Autowired
	public void setMultitenancyProperties(MultitenantProperties multitenantProperties,
										  CredentialsService credentialService) {
		this.multitenantProperties = multitenantProperties;
		this.credentialService = credentialService;
	}

	public boolean migrate() {
		multitenantProperties.getDatasources().stream().forEach(dataSource -> {
			try {
				logger.info("Starting flyway migration for locations" + dataSource.getLocation());

				if(dataSource.getSecret() != null ) {
					logger.info("getting the password from credential service	 using key "+dataSource.getSecret());
					MarsDBSecret marsDBSecret =  credentialService.getCachedSecret(dataSource.getSecret(),false, MarsDBSecret.class);
					dataSource.setUsername(marsDBSecret.getUsername());
					dataSource.setPassword(marsDBSecret.getPassword());
				}else {
					dataSource.setUsername(dataSource.getUsername());
					dataSource.setPassword(dataSource.getPassword());
				}

				Flyway flyway = Flyway.configure()
						.dataSource(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword())
						.baselineOnMigrate(true)
						.outOfOrder(outOfOrder.booleanValue())
						.locations(dataSource.getLocation()).load();
				logger.info("Performing repair ");
				flyway.repair();
				logger.info("Migrating  ");
				flyway.migrate();
				logger.info("Flyway migration information " + flyway.info());
				logger.info("Finished flyway migration for locations" + dataSource.getLocation());
			} catch (Exception e) {
				logger.error("Error flyway migration for locations :" + dataSource.getLocation(),e);
			}
		});
		return true;
	}

}
