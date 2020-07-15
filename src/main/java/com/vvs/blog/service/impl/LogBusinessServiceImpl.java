package com.vvs.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.vvs.blog.entity.Account;
import com.vvs.blog.entity.Article;
import com.vvs.blog.entity.Comment;
import com.vvs.blog.exception.ApplicationException;
import com.vvs.blog.exception.ValidateException;
import com.vvs.blog.form.CommentForm;
import com.vvs.blog.model.SocialAccount;

class LogBusinessServiceImpl extends BusinessServiceImpl {

	LogBusinessServiceImpl(ServiceManager serviceManager) {
		super(serviceManager);
	}
	
	@Override
	public Comment createComment(CommentForm form) throws ValidateException {
		form.validate(i18nService);
		try (Connection c = dataSource.getConnection()) {
			SocialAccount socialAccount = socialService.getSocialAccount(form.getAuthToken());
			Account a = new Account();
			a.setId(0L);
			a.setAvatar(socialAccount.getAvatar());
			a.setCreated(new Timestamp(System.currentTimeMillis()));
			a.setEmail(socialAccount.getEmail());
			a.setName(socialAccount.getName());
			Comment comment = new Comment(form.getIdArticle(), a, form.getContent(), new Timestamp(System.currentTimeMillis()));
			Article article = sql.findArticleForNewCommentNotification(c, form.getIdArticle());
			sendNewCommentNotification(article, form.getContent(), form.getLocale());
			return comment;
		} catch (SQLException e) {
			throw new ApplicationException("Can't execute db command: " + e.getMessage(), e);
		}
	}
}
