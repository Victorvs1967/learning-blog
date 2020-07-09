package com.vvs.blog.service;

import java.util.Map;

import com.vvs.blog.entity.Article;
import com.vvs.blog.entity.Category;
import com.vvs.blog.model.Items;

public interface BusinessService {
	
	Map<Long, Category> mapCategories();
	
	Items<Article> listArticles(int offset, int limit);

	Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit);

	Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit);

	Category findCategoryByUrl(String categoryUrl);

}
