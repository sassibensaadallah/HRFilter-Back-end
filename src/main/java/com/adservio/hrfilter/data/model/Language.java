package com.adservio.hrfilter.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String foundInContext;
	private String language;
	private String languageCode;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private ResumeData resumeData;

}
