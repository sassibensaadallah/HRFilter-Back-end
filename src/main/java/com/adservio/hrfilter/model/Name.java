package com.adservio.hrfilter.model;

public class Name {
	private String Raw;
	private String Normalized;
	private String Probability;
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
	public String getProbability() {
		return Probability;
	}
	public void setProbability(String probability) {
		Probability = probability;
	}
	@Override
	public String toString() {
		return "Name [Raw=" + Raw + ", Normalized=" + Normalized + ", Probability=" + Probability + "]";
	}
	
	
}
