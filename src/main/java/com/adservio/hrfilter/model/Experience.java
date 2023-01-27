package com.adservio.hrfilter.model;

public class Experience {
	private int Value;

	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

	@Override
	public String toString() {
		return "Experience [Value=" + Value + "]";
	}
	
}
