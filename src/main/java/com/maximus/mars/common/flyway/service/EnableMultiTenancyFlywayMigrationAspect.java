package com.maximus.mars.common.flyway.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class EnableMultiTenancyFlywayMigrationAspect {

	@Autowired
	EnableMultiTenancyFlywayMigrationImpl flywayMigrationImpl;

	@Around("@annotation(EnableMultiTenancyFlywayMigration)")
	public Object migrate(ProceedingJoinPoint joinPoint) throws Throwable {
		flywayMigrationImpl.migrate();
		return joinPoint.proceed();
	}	

}
