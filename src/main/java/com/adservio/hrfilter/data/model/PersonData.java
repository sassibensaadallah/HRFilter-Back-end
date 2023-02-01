package com.adservio.hrfilter.data.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PersonData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long personId;
	
	private String firstName;
	private String lastName;
	private List<String> phoneNumbers=new ArrayList<>();
	private List<String> mailAdresses=new ArrayList<>();
	@OneToOne(mappedBy = "personData")
	private ResumeData resumeData;
	private String country;
	
	//from Employment history
	private String description;
	private int experience;
	private int averageByEmployer;
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public List<String> getMailAdresses() {
		return mailAdresses;
	}
	public void setMailAdresses(List<String> mailAdresses) {
		this.mailAdresses = mailAdresses;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getAverageByEmployer() {
		return averageByEmployer;
	}
	public void setAverageByEmployer(int averageByEmployer) {
		this.averageByEmployer = averageByEmployer;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "PersonData [personId=" + personId + ", name=" + firstName + ", phoneNumbers=" + phoneNumbers
				+ ", mailAdresses=" + mailAdresses + ", country=" + country + ", description=" + description
				+ ", experience=" + experience + ", averageByEmployer=" + averageByEmployer + "]";
	}
	
	
	
}
