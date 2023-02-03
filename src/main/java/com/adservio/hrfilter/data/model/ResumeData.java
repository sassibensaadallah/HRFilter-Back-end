package com.adservio.hrfilter.data.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ResumeData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resumeId;
	@ElementCollection
	private List<String>certifications=new ArrayList<>();
	@ElementCollection
	private List<String>languages=new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "personId")
	private PersonData personData ;
	
	private String professionalSummary;
	
	@OneToMany(mappedBy="resumeData",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<EmployerData> employerList=new ArrayList<>();
	
	@OneToMany(mappedBy="resumeData",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<SkillDataModel>skills=new ArrayList<>();
	//HighestDegree from education
	private String highestDegree;
	
	@OneToMany(mappedBy="resumeData",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<EducationData> educationList=new ArrayList<>();

	public Long getResumeId() {
		return resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

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

	public List<SkillDataModel> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillDataModel> skills) {
		this.skills = skills;
		for(SkillDataModel skillData:skills) {
			skillData.setResumeData(this);
		}
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}

	public List<EmployerData> getEmployerList() {
		return employerList;
	}

	public void setEmployerList(List<EmployerData> employerList) {
		this.employerList = employerList;
		for(EmployerData employerData:employerList) {
			employerData.setResumeData(this);
		}
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public List<EducationData> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<EducationData> educationList) {
		this.educationList = educationList;
		for(EducationData educationData:educationList) {
			educationData.setResumeData(this);
		}
	}

	public String getProfessionalSummary() {
		return professionalSummary;
	}

	public void setProfessionalSummary(String professionalSummary) {
		this.professionalSummary = professionalSummary;
	}	
}
