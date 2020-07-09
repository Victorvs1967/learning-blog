package com.vvs.blog.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.vvs.blog.dao.mapper.ArticleMapper;
import com.vvs.blog.dao.mapper.ListMapper;
import com.vvs.blog.dao.mapper.MapCategoryMapper;
import com.vvs.blog.entity.Category;
import com.vvs.blog.entity.Article;

public final class SQLDAO {

	private final QueryRunner sql = new QueryRunner();
	
	public Map<Long, Category> mapCategories(Connection c) throws SQLException {
		return sql.query(c, "select * from category", new MapCategoryMapper());
	}
	
	public List<Article> listArticles(Connection c, int offset, int limit) throws SQLException {
		return sql.query(c, "select * from article a order by a.id desc limit ? offset ?", new ListMapper<>(new ArticleMapper()), limit, offset);
	}
	
	public int countArticles(Connection c) throws SQLException {
		return sql.query(c, "select count(*) from article a", new ScalarHandler<Number>()).intValue();
	}
	
	public List<Article> listArticlesByCategory(Connection c, String categoryUrl, int offset, int limit) throws SQLException {
		return sql.query(c, "select a.* from article a, category c where c.id=a.id_category and c.url=? order by a.id desc limit ? offset ?", 
				new ListMapper<>(new ArticleMapper()), categoryUrl, limit, offset);
	}
	
	public int countArticlesByCategory(Connection c, String categoryUrl) throws SQLException {
		return sql.query(c, "select count(a.id) from article a, category c where a.id_category=c.id and c.url=?", new ScalarHandler<Number>(), categoryUrl).intValue();
	}
	
	public Category findCategoryByUrl(Connection c, String categoryUrl) throws SQLException {
		return sql.query(c, "select * from category c where c.url = ?", new BeanHandler<>(Category.class), categoryUrl);
	}
}