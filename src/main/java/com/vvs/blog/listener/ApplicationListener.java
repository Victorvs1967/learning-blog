package com.vvs.blog.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vvs.blog.Constants;
import com.vvs.blog.entity.Category;
import com.vvs.blog.service.impl.ServiceManager;

@WebListener
public class ApplicationListener implements ServletContextListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServiceManager serviceManager =  ServiceManager.getInstance(sce.getServletContext());
		Map<Long, Category> map = serviceManager.getBusinessService().mapCategories();
		sce.getServletContext().setAttribute("social_googleplus_clientId", serviceManager.getApplicationProperties("social.googleplus.clientId"));
		sce.getServletContext().setAttribute(Constants.CATEGORY_MAP, map);
		LOGGER.info("Application started");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext()).destroy();		
		LOGGER.info("Application destroyed");
	}
}
