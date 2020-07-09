package com.vvs.blog.service;

import java.util.Map;

import com.vvs.blog.entity.Article;
import com.vvs.blog.entity.Category;
import com.vvs.blog.model.Items;

public interface BusinessService {
	
	Map<Long, Category> mapCategories();
	
	Items<Article> listArticles(int offset, int limit);

	Items<Article> listArticlesByCategory(String categoryUrl, int i, int limitArticlesPerPage);

	Category findCategoryByUrl(String categoryUrl);

}
