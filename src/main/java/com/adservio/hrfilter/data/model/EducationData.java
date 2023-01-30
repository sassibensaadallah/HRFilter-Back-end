package com.adservio.hrfilter.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EducationData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long educationId;
	@ManyToOne()
    @JoinColumn(name="resumeId")
	private ResumeData resumeData;
	
	private String schoolName;
	private String degree;
	private String descrption;
	private String lastDate;
	public Long getEducationId() {
		return educationId;
	}
	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public ResumeData getResumeData() {
		return resumeData;
	}
	public void setResumeData(ResumeData resumeData) {
		this.resumeData = resumeData;
	}
	
}
