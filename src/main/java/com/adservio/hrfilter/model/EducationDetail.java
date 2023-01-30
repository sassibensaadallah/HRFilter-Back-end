package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;

public class EducationDetail {
	private String Text;
	private Name SchoolName;
	private String SchoolType;
	private Degree Degree;
	private List<String>Majors= new ArrayList<>();
	private Date LastEducationDate;
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public Name getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(Name schoolName) {
		SchoolName = schoolName;
	}
	public String getSchoolType() {
		return SchoolType;
	}
	public void setSchoolType(String schoolType) {
		SchoolType = schoolType;
	}
	public Degree getDegree() {
		return Degree;
	}
	public void setDegree(Degree degree) {
		Degree = degree;
	}
	public List<String> getMajors() {
		return Majors;
	}
	public void setMajors(List<String> majors) {
		Majors = majors;
	}
	public Date getLastEducationDate() {
		return LastEducationDate;
	}
	public void setLastEducationDate(Date lastEducationDate) {
		LastEducationDate = lastEducationDate;
	}
	@Override
	public String toString() {
		return "EducationDetail [Text=" + Text + ", SchoolName=" + SchoolName + ", SchoolType=" + SchoolType
				+ ", Degree=" + Degree + ", Majors=" + Majors + ", LastEducationDate=" + LastEducationDate + "]";
	}
	
}
