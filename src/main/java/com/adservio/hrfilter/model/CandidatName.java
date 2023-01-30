package com.adservio.hrfilter.model;

public class CandidatName {
	
	private String FormattedName;
	private String Prefix;
	private String GivenName;
	private String Moniker;
	private String MiddleName;
	private String FamilyName;
	public String getFormattedName() {
		return FormattedName;
	}
	public void setFormattedName(String formattedName) {
		FormattedName = formattedName;
	}
	public String getPrefix() {
		return Prefix;
	}
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	public String getGivenName() {
		return GivenName;
	}
	public void setGivenName(String givenName) {
		GivenName = givenName;
	}
	public String getMoniker() {
		return Moniker;
	}
	public void setMoniker(String moniker) {
		Moniker = moniker;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getFamilyName() {
		return FamilyName;
	}
	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}
	@Override
	public String toString() {
		return "CandidatName [FormattedName=" + FormattedName + ", Prefix=" + Prefix + ", GivenName=" + GivenName
				+ ", Moniker=" + Moniker + ", MiddleName=" + MiddleName + ", FamilyName=" + FamilyName + "]";
	}
	
	
	
	
}
