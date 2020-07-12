package com.vvs.blog.service;

import java.util.List;
import java.util.Map;

import com.vvs.blog.entity.Article;
import com.vvs.blog.entity.Category;
import com.vvs.blog.entity.Comment;
import com.vvs.blog.exception.RedirectToValidUrlException;
import com.vvs.blog.model.Items;

public interface BusinessService {
	
	Map<Long, Category> mapCategories();
	
	Items<Article> listArticles(int offset, int limit);

	Items<Article> listArticlesByCategory(String categoryUrl, int offset, int limit);

	/**
	 * @return null if entity not found
	 */
	
	Category findCategoryByUrl(String categoryUrl);

	Items<Article> listArticlesBySearchQuery(String searchQuery, int offset, int limit);
	
	/**
	 * @return null if entity not found by idArticle
	 */

	Article viewArticle(long idArticle, String requestUrl) throws RedirectToValidUrlException;
	
	List<Comment> listComments(long idArticle, int offset, int limit);
	
}
