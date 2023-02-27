package com.adservio.hrfilter.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Certification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private boolean isVariation;
	private String name;
	private boolean matchedFromList;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private ResumeData resumeData;



}
