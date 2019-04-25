package com.maximus.mars.common.flyway.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@EnableMultiTenancyFlywayMigration
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@TestPropertySource(
		locations = "classpath:application-test.properties")
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class EnableMultiTenancyFlywayMigrationTest {

	@Test
	public void testMigrate() {
	}	
	
}
