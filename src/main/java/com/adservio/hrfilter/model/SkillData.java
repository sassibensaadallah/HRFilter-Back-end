package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;


public class SkillData {
	private Long skillId;
	private String Root;
	private List<Taxonomy> Taxonomies= new ArrayList<>();
	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getRoot() {
		return Root;
	}
	public void setRoot(String root) {
		Root = root;
	}
	public List<Taxonomy> getTaxonomies() {
		return Taxonomies;
	}
	public void setTaxonomies(List<Taxonomy> taxonomies) {
		Taxonomies = taxonomies;
	}
	@Override
	public String toString() {
		return "SkillData [skillId=" + skillId + ", Root=" + Root + ", Taxonomies=" + Taxonomies + "]";
	}
	
	
}
