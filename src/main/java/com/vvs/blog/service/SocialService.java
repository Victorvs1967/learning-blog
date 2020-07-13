package com.vvs.blog.service;

import com.vvs.blog.model.SocialAccount;

public interface SocialService {
	
	SocialAccount getSocialAccount(String authToken);

}
