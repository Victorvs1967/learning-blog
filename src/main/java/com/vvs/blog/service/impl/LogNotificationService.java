package com.vvs.blog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vvs.blog.service.NotificationService;

public class LogNotificationService implements NotificationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogNotificationService.class);

	@Override
	public void sendNotification(String title, String content) {
		LOGGER.info("New comment: title=" + title + ", content=" + content);
	}

	@Override
	public void shutdown() {

	}

}
