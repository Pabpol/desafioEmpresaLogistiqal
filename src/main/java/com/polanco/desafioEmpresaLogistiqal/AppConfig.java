package com.polanco.desafioEmpresaLogistiqal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.polanco.desafioBibliotecaBooklet")
@PropertySource("classpath:database.properties")
public class AppConfig {
	
	@Autowired
	Environment ambient;
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(ambient.getProperty("driver"));
		dmds.setUrl(ambient.getProperty("url"));
		dmds.setUsername(ambient.getProperty("user"));
		dmds.setPassword(ambient.getProperty("password"));
		
		return dmds; 
	}
	
	

}