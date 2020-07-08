package com.vvs.blog.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.vvs.blog.dao.mapper.MapCategoryMapper;
import com.vvs.blog.entity.Category;

public final class SQLDAO {

	private final QueryRunner sql = new QueryRunner();
	
	public Map<Long, Category> mapCategories(Connection c) throws SQLException {
		
		return sql.query(c, "select * from category", new MapCategoryMapper());
	}
}
