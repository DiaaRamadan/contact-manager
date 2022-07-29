package com.spring.contact.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		var applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(MvcConfig.class);
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
