package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;

public class Employment {
	private EmploymentSummary ExperienceSummary;
	List<Position> Positions=new ArrayList<>();
	public EmploymentSummary getExperienceSummary() {
		return ExperienceSummary;
	}
	public void setExperienceSummary(EmploymentSummary experienceSummary) {
		ExperienceSummary = experienceSummary;
	}
	public List<Position> getPositions() {
		return Positions;
	}
	public void setPositions(List<Position> positions) {
		Positions = positions;
	}
	@Override
	public String toString() {
		return "Employment [ExperienceSummary=" + ExperienceSummary + ", Positions=" + Positions + "]";
	}
	
	
}
