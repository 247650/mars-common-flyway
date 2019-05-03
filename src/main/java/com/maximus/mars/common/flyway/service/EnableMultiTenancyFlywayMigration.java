package com.maximus.mars.common.flyway.service;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
//@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface EnableMultiTenancyFlywayMigration {
}
