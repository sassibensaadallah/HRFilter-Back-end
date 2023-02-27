package com.adservio.hrfilter.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmployerData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long employerId;
	@ManyToOne
    @JoinColumn(name="resumeId", referencedColumnName ="resumeId")
	@JsonIgnore
	private ResumeData resumeData;
	
	private String name;
	private String jobTitle;
	private String startDate;
	private String endDate;
	private String description;
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
//	public ResumeData getResumeData() {
//		return resumeData;
//	}
	public void setResumeData(ResumeData resumeData) {
		this.resumeData = resumeData;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
