package com.adservio.hrfilter.model;

import java.util.ArrayList;
import java.util.List;

public class Taxonomy {
	private Long taxonomyId;
	
	private String Name;
	
	private List<SubTaxonomy> SubTaxonomies= new ArrayList<>();

	public Long getTaxonomyId() {
		return taxonomyId;
	}

	public void setTaxonomyId(Long taxonomyId) {
		this.taxonomyId = taxonomyId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<SubTaxonomy> getSubTaxonomies() {
		return SubTaxonomies;
	}

	public void setSubTaxonomies(List<SubTaxonomy> subTaxonomies) {
		SubTaxonomies = subTaxonomies;
	}

	@Override
	public String toString() {
		return "Taxonomy [taxonomyId=" + taxonomyId + ", Name=" + Name + ", SubTaxonomies=" + SubTaxonomies + "]";
	}
	
	
	

}
