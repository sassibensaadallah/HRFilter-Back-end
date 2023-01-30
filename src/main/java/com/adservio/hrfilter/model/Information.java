package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;

public class Information {
	private CandidatName CandidateName;
	private List<Telephone>Telephones=new ArrayList<>();
	private List<String> EmailAddresses= new ArrayList<>();
	private Location Location;
	public CandidatName getCandidateName() {
		return CandidateName;
	}
	public void setCandidateName(CandidatName candidateName) {
		CandidateName = candidateName;
	}
	public List<Telephone> getTelephones() {
		return Telephones;
	}
	public void setTelephones(List<Telephone> telephones) {
		Telephones = telephones;
	}
	public List<String> getEmailAddresses() {
		return EmailAddresses;
	}
	public void setEmailAddresses(List<String> emailAddresses) {
		EmailAddresses = emailAddresses;
	}
	public Location getLocation() {
		return Location;
	}
	public void setLocation(Location location) {
		Location = location;
	}
	@Override
	public String toString() {
		return "Information [CandidateName=" + CandidateName + ", Telephones=" + Telephones + ", EmailAddresses="
				+ EmailAddresses + ", Location=" + Location + "]";
	}
	
	
	
}
