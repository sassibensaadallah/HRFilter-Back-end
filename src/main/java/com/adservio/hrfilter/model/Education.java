package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;

public class Education {
	private Degree HighestDegree;
	private List <EducationDetail>EducationDetails=new ArrayList<>();
	public Degree getHighestDegree() {
		return HighestDegree;
	}
	public void setHighestDegree(Degree highestDegree) {
		HighestDegree = highestDegree;
	}
	public List<EducationDetail> getEducationDetails() {
		return EducationDetails;
	}
	public void setEducationDetails(List<EducationDetail> educationDetails) {
		EducationDetails = educationDetails;
	}
	@Override
	public String toString() {
		return "Education [HighestDegree=" + HighestDegree + ", EducationDetails=" + EducationDetails + "]";
	}
	
	
}
