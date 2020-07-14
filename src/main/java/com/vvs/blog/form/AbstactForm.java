package com.vvs.blog.form;

import java.util.Locale;

import com.vvs.blog.exception.ValidateException;
import com.vvs.blog.model.AbstractModel;
import com.vvs.blog.service.I18nService;

public abstract class AbstactForm extends AbstractModel {
	
	protected Locale locale;
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public Locale getLocale() {
		return locale;
	}
	public void validate(I18nService i18nService) throws ValidateException {
		
	}
}
