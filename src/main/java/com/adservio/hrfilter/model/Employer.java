package com.adservio.hrfilter.model;

public class Employer {
	private Name Name;

	public Name getName() {
		return Name;
	}

	public void setName(Name name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Employer [Name=" + Name + "]";
	}
	
}
