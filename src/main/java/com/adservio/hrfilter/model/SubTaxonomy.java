package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;

public class SubTaxonomy {
	private String SubTaxonomyName;
	private int PercentOfOverall;
	private List<Skill> Skills= new ArrayList<>();
	public String getSubTaxonomyName() {
		return SubTaxonomyName;
	}
	public void setSubTaxonomyName(String subTaxonomyName) {
		SubTaxonomyName = subTaxonomyName;
	}
	public int getPercentOfOverall() {
		return PercentOfOverall;
	}
	public void setPercentOfOverall(int percentOfOverall) {
		PercentOfOverall = percentOfOverall;
	}
	public List<Skill> getSkills() {
		return Skills;
	}
	public void setSkills(List<Skill> skills) {
		Skills = skills;
	}
	@Override
	public String toString() {
		return "SubTaxonomy [SubTaxonomyName=" + SubTaxonomyName + ", PercentOfOverall=" + PercentOfOverall
				+ ", Skills=" + Skills + "]";
	}
	
	
}
