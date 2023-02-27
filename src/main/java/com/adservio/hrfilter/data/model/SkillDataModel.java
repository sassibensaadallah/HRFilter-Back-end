package com.adservio.hrfilter.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class SkillDataModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long skillDataModelId;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="resumeId")
	@JsonIgnore
	private ResumeData resumeData;
	private String skillName;
	private int experienceInMonth;
	private String type;

}
