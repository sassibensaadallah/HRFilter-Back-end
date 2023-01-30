package com.adservio.hrfilter.model;


public class Certification {
	
	private Long languageId;
	private String Name;
	private boolean MatchedFromList;
	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isMatchedFromList() {
		return MatchedFromList;
	}
	public void setMatchedFromList(boolean matchedFromList) {
		MatchedFromList = matchedFromList;
	}
	@Override
	public String toString() {
		return "Certification [languageId=" + languageId + ", Name=" + Name + ", MatchedFromList=" + MatchedFromList
				+ "]";
	}
	
	
}
