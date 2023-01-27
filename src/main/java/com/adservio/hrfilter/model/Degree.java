package com.adservio.hrfilter.model;

public class Degree {
	private Name Name;
	private String Type;
	public Name getName() {
		return Name;
	}
	public void setName(Name name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "Degree [Name=" + Name + ", Type=" + Type + "]";
	}
	
}
