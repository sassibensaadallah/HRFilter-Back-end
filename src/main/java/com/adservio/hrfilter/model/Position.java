package com.adservio.hrfilter.model;

public class Position {
	private Employer employer;
	private boolean IsSelfEmployed;
	private boolean IsCurrent;
	private Name JobTitle;
	private Date StartDate;
	private Date EndDate;
	private String description;
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public boolean isIsSelfEmployed() {
		return IsSelfEmployed;
	}
	public void setIsSelfEmployed(boolean isSelfEmployed) {
		IsSelfEmployed = isSelfEmployed;
	}
	public boolean isIsCurrent() {
		return IsCurrent;
	}
	public void setIsCurrent(boolean isCurrent) {
		IsCurrent = isCurrent;
	}
	public Name getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(Name jobTitle) {
		JobTitle = jobTitle;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Position [employer=" + employer + ", IsSelfEmployed=" + IsSelfEmployed + ", IsCurrent=" + IsCurrent
				+ ", JobTitle=" + JobTitle + ", StartDate=" + StartDate + ", EndDate=" + EndDate + "]";
	}
	
	
}
