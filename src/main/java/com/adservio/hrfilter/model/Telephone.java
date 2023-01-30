package com.adservio.hrfilter.model;

public class Telephone {
	private String Raw;
	private String Normalized;
	private String InternationalCountryCode;
	private String AreaCityCode;
	private String SubscriberNumber;
	public String getRaw() {
		return Raw;
	}
	public void setRaw(String raw) {
		Raw = raw;
	}
	public String getNormalized() {
		return Normalized;
	}
	public void setNormalized(String normalized) {
		Normalized = normalized;
	}
	public String getInternationalCountryCode() {
		return InternationalCountryCode;
	}
	public void setInternationalCountryCode(String internationalCountryCode) {
		InternationalCountryCode = internationalCountryCode;
	}
	public String getAreaCityCode() {
		return AreaCityCode;
	}
	public void setAreaCityCode(String areaCityCode) {
		AreaCityCode = areaCityCode;
	}
	public String getSubscriberNumber() {
		return SubscriberNumber;
	}
	public void setSubscriberNumber(String subscriberNumber) {
		SubscriberNumber = subscriberNumber;
	}
	@Override
	public String toString() {
		return "Telephone [Raw=" + Raw + ", Normalized=" + Normalized + ", InternationalCountryCode="
				+ InternationalCountryCode + ", AreaCityCode=" + AreaCityCode + ", SubscriberNumber=" + SubscriberNumber
				+ "]";
	}

	
}
