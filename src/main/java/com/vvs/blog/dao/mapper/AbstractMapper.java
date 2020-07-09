package com.vvs.blog.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;

public abstract class AbstractMapper<T> implements ResultSetHandler<T> {
	
	protected final RowProcessor convert = new BasicRowProcessor();
	boolean shouldBeIterateThroughResultSet = true;
	
	@Override
	public T handle(ResultSet rs) throws SQLException {
		
		if (shouldBeIterateThroughResultSet) {
			if (rs.next()) {
				return handleItem(rs);
			} else {
				return null;
			}
		} else {
			return handleItem(rs);
		}
	}

	protected abstract T handleItem(ResultSet rs) throws SQLException;

}
