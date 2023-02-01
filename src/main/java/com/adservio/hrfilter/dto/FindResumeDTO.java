package com.adservio.hrfilter.dto;

import java.util.List;

public class FindResumeDTO {
	private List<String> certifications;
	private List<String> languages;
	private String highestDegree;
	private List<String> skills;
	private int experience;
	
	public List<String> getCertifications() {
		return certifications;
	}
	public void setCertifications(List<String> certifications) {
		this.certifications = certifications;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
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
