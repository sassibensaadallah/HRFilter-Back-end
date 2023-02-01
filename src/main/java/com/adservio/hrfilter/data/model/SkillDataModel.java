package com.adservio.hrfilter.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class SkillDataModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long skillDataModelId;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="resumeId")
	private ResumeData resumeData;
	private String skillName;
	private int experienceInMonth;
	public Long getSkillDataModelId() {
		return skillDataModelId;
	}
	public void setSkillDataModelId(Long skillDataModelId) {
		this.skillDataModelId = skillDataModelId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getExperienceInMonth() {
		return experienceInMonth;
	}
	public void setExperienceInMonth(int experienceInMonth) {
		this.experienceInMonth = experienceInMonth;
	}
//	public ResumeData getResumeData() {
//		return resumeData;
//	}
	public void setResumeData(ResumeData resumeData) {
		this.resumeData = resumeData;
	}
	
}
