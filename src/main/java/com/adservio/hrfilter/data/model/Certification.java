package com.adservio.hrfilter.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

	private String date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private ResumeData resumeData;



}
