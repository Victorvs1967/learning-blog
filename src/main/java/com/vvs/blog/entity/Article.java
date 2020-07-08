package com.vvs.blog.entity;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

public class Article extends AbstractEntity<Long> {

	private static final long serialVersionUID = 2290460609652005346L;
	
	private String title;
	private String url;
	private String logo;
	private String description;
	private String content;
	private long idCategory;
	private Timestamp created;
	private int views;
	private int comments;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getArticleLink() {
		return "/article/" + getId() + url;
	}
	public String getShortTitle() {
		if (StringUtils.length(title) > 20) {
			return title.substring(0,  17) + "...";
		} else {
			return title;
		}
	}
	
}
