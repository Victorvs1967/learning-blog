package com.vvs.blog.service;


public interface NotificationService {
	
	void sendNotification(String title, String content);
	void shutdown();
		
}
