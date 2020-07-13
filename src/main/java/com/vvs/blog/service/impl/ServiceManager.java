package com.vvs.blog.service.impl;

import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vvs.blog.service.BusinessService;
import com.vvs.blog.util.AppUtil;

public class ServiceManager {

	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute(SERVICE_MANAGER);
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute(SERVICE_MANAGER, instance);
		}
		return instance;
	}
	
	public void destroy() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			LOGGER.error("Close database faild: " + e.getMessage(), e);		
		}
		LOGGER.info("ServiceManager instance destroyed");		
	}
	 
	public BusinessService getBusinessService() {
		return businessService;
	}
	
	public String getApplicationPropertyString(String property) {
		return applicationProperties.getProperty(property);
	}
	
	private static final String SERVICE_MANAGER = "SERVICE_MANAGER";
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

	final Properties applicationProperties = new Properties();
	final BusinessService businessService;
	final BasicDataSource dataSource; 
	final ServletContext applicationContext;
	
	private ServiceManager(ServletContext context) {
		this.applicationContext = context;
		AppUtil.loadProperties(applicationProperties, "application.properties");
		dataSource = createBasicDataSource();
		businessService = new BusinessServiceImpl(this);
		LOGGER.info("ServiceManager instance created");
	}
	
	private BasicDataSource createBasicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDefaultAutoCommit(false);
		ds.setRollbackOnReturn(true);
		ds.setDriverClassName(getApplicationPropertyString("db.driver"));
		ds.setUrl(getApplicationPropertyString("db.url"));
		ds.setUsername(getApplicationPropertyString("db.username"));
		ds.setPassword(getApplicationPropertyString("db.password"));
		ds.setInitialSize(Integer.parseInt(getApplicationPropertyString("db.pool.initSize")));
		ds.setMaxTotal(Integer.parseInt(getApplicationPropertyString("db.pool.maxSize")));
		
		return ds;
	}
	
}
