package com.adservio.hrfilter.model;


public class Language {

	private Long languageId;
	private String Language;
	private String LanguageCode;

	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getLanguageCode() {
		return LanguageCode;
	}
	public void setLanguageCode(String languageCode) {
		LanguageCode = languageCode;
	}
	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", Language=" + Language + ", LanguageCode=" + LanguageCode + "]";
	}

	
	
}
