package com.spring.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.contact.dao.ContactDao;
import com.spring.contact.dao.ContactDaoImp;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.contact")
public class MvcConfig implements WebMvcConfigurer {

	@Bean
	public DataSource getDateSource() {
		var dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3366/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("P@ssword");
		return dataSource;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		var resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ContactDao getContactDao() {
		return new ContactDaoImp(getDateSource());
	}
	
}
