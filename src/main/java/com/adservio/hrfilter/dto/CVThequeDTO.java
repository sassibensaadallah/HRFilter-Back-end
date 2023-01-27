package com.adservio.hrfilter.dto;


public class CVThequeDTO {
	private ResumeValue Value;

	public ResumeValue getValue() {
		return Value;
	}

	public void setValue(ResumeValue value) {
		Value = value;
	}

	@Override
	public String toString() {
		return "CVThequeDTO [Value=" + Value + "]";
	}
	
}
