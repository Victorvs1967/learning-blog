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
	
	public String getApplicationProperties(String property) {
		return applicationProperties.getProperty(property);
	}
	
	private static final String SERVICE_MANAGER = "SERVICE_MANAGER";
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

	final Properties applicationProperties = new Properties();
	final BusinessService businessService;
	final BasicDataSource dataSource; 
	
	private ServiceManager(ServletContext context) {
		AppUtil.loadProperties(applicationProperties, "application.properties");
		dataSource = createBasicDataSource();
		businessService = new BusinessServiceImpl();
		LOGGER.info("ServiceManager instance created");
	}
	
	private BasicDataSource createBasicDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDefaultAutoCommit(false);
		ds.setRollbackOnReturn(true);
		ds.setDriverClassName(getApplicationProperties("db.driver"));
		ds.setUrl(getApplicationProperties("db.url"));
		ds.setUsername(getApplicationProperties("db.username"));
		ds.setPassword(getApplicationProperties("db.password"));
		ds.setInitialSize(Integer.parseInt(getApplicationProperties("db.pool.initSize")));
		ds.setMaxTotal(Integer.parseInt(getApplicationProperties("db.pool.maxSize")));
		
		return ds;
	}
	
}
