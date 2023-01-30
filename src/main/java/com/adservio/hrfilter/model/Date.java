package com.adservio.hrfilter.model;

public class Date {
	private String Date;
	private boolean IsCurrentDate;
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public boolean isIsCurrentDate() {
		return IsCurrentDate;
	}
	public void setIsCurrentDate(boolean isCurrentDate) {
		IsCurrentDate = isCurrentDate;
	}
	@Override
	public String toString() {
		return "Date [Date=" + Date + ", IsCurrentDate=" + IsCurrentDate + "]";
	}
	
}
