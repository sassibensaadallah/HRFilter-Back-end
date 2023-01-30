package com.adservio.hrfilter.model;

public class Skill {
	private String Name;
	private Experience MonthsExperience;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Experience getMonthsExperience() {
		return MonthsExperience;
	}
	public void setMonthsExperience(Experience monthsExperience) {
		MonthsExperience = monthsExperience;
	}
	@Override
	public String toString() {
		return "Skill [Name=" + Name + ", MonthsExperience=" + MonthsExperience + "]";
	}
	
	
}
