package com.booklet.books;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.booklet.books")
@PropertySource("classpath:database:properties")
public class AppConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	DataSource datasource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("url"));
		driverManagerDataSource.setUsername(environment.getProperty("dbUser"));
		driverManagerDataSource.setPassword(environment.getProperty("dbUserPassword"));

		driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
		
		return driverManagerDataSource;
	}

}
