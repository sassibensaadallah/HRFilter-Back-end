package com.adservio.hrfilter.model;

public class EmploymentSummary {
	private String Description;
	private int MonthsOfWorkExperience;
	private int AverageMonthsPerEmployer;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getMonthsOfWorkExperience() {
		return MonthsOfWorkExperience;
	}
	public void setMonthsOfWorkExperience(int monthsOfWorkExperience) {
		MonthsOfWorkExperience = monthsOfWorkExperience;
	}
	public int getAverageMonthsPerEmployer() {
		return AverageMonthsPerEmployer;
	}
	public void setAverageMonthsPerEmployer(int averageMonthsPerEmployer) {
		AverageMonthsPerEmployer = averageMonthsPerEmployer;
	}
	@Override
	public String toString() {
		return "EmploymentSummary [Description=" + Description + ", MonthsOfWorkExperience=" + MonthsOfWorkExperience
				+ ", AverageMonthsPerEmployer=" + AverageMonthsPerEmployer + "]";
	}
	
	
	
}
