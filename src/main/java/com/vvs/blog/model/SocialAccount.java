package com.vvs.blog.model;

public final class SocialAccount extends AbstractModel {
	
	private final String email;
	private final String name;
	private final String avatar;
	
	public SocialAccount(String email, String name, String avatar) {
		super();
		this.email = email;
		this.name = name;
		this.avatar = avatar;
	}
	
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getAvatar() {
		return avatar;
	}

	

}
