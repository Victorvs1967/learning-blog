package com.vvs.blog.exception;


public class RedirectToValidUrlException extends Exception {

	private static final long serialVersionUID = -8012329495586183301L;

	private String url;

	public RedirectToValidUrlException(String url) {
		super("Shoud be redidert to " + url);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

}
