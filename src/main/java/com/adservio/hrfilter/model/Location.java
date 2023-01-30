package com.adservio.hrfilter.model;

public class Location {
	private String CountryCode;
	private String PostalCode;
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Location [CountryCode=" + CountryCode + ", PostalCode=" + PostalCode + "]";
	}
	
}
