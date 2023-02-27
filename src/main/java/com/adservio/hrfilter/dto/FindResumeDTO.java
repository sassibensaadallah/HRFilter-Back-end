package com.adservio.hrfilter.dto;

import java.util.List;

public class FindResumeDTO {
	private List<CertificationDto> certifications;
	private List<LanguageDto> languages;
	private String highestDegree;
	private List<String> skills;
	private int experience;
	
	public List<CertificationDto> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<CertificationDto> certifications) {
		this.certifications = certifications;
	}
	public List<LanguageDto> getLanguages() {
		return languages;
	}
	public void setLanguages(List<LanguageDto> languages) {
		this.languages = languages;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
}
