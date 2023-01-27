package com.adservio.hrfilter.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Resume {

//	private Long resumeId;
//	
	private String ProfessionalSummary;

	private Information ContactInformation;
	

	private Education Education;
	

	private Employment EmploymentHistory;
	
	private List<SkillData> SkillsData= new ArrayList<>();
	
	private List<Certification> Certifications= new ArrayList<>();
	
	private List<Language> LanguageCompetencies= new ArrayList<>();

//	public Long getResumeId() {
//		return resumeId;
//	}
//
//	public void setResumeId(Long resumeId) {
//		this.resumeId = resumeId;
//	}
//
	public String getProfessionalSummary() {
		return ProfessionalSummary;
	}

	public void setProfessionalSummary(String professionalSummary) {
		ProfessionalSummary = professionalSummary;
	}

	public Information getContactInformation() {
		return ContactInformation;
	}

	public void setContactInformation(Information contactInformation) {
		ContactInformation = contactInformation;
	}

	public Education getEducation() {
		return Education;
	}

	public void setEducation(Education education) {
		Education = education;
	}

	public Employment getEmploymentHistory() {
		return EmploymentHistory;
	}

	public void setEmploymentHistory(Employment employmentHistory) {
		EmploymentHistory = employmentHistory;
	}

	public List<SkillData> getSkillsData() {
		return SkillsData;
	}

	public void setSkillsData(List<SkillData> skillsData) {
		SkillsData = skillsData;
	}

	public List<Certification> getCertifications() {
		return Certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		Certifications = certifications;
	}

	public List<Language> getLanguageCompetencies() {
		return LanguageCompetencies;
	}

	public void setLanguageCompetencies(List<Language> languageCompetencies) {
		LanguageCompetencies = languageCompetencies;
	}
	
	
}
