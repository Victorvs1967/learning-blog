package com.vvs.blog.service.impl;

import java.util.Map;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.vvs.blog.service.BusinessService;
import com.vvs.blog.dao.SQLDAO;
import com.vvs.blog.entity.Category;
import com.vvs.blog.exception.ApplicationException;


class BusinessServiceImpl implements BusinessService {
	
	private final DataSource dataSource;
	private final SQLDAO sql;
	
	BusinessServiceImpl(ServiceManager serviceManager) {
		super();
		
		this.dataSource = serviceManager.dataSource;
		this.sql = new SQLDAO();
	}
	
	@Override
	public Map<Long, Category> mapCategories() {
		
		try (Connection c = dataSource.getConnection()) {
			return sql.mapCategories(c);
		} catch (SQLException e) {
			throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
		}
		
	}

}
 