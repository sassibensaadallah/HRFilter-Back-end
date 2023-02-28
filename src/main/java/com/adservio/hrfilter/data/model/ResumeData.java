package com.adservio.hrfilter.data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class ResumeData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resumeId;
	/*@ElementCollection
	private List<String>certifications=new ArrayList<>();
	@ElementCollection
	private List<String>languages=new ArrayList<>();*/
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "personId")
	private PersonData personData ;

	@OneToMany(mappedBy = "resumeData",cascade = CascadeType.ALL)
	private List<Language> languages;

	@OneToMany(mappedBy = "resumeData",cascade = CascadeType.ALL)
	private List<Certification> certifications;



	
	private String professionalSummary;
	
	@OneToMany(mappedBy="resumeData",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<EmployerData> employerList=new ArrayList<>();
	
	@OneToMany(mappedBy="resumeData",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<SkillDataModel> skills=new ArrayList<>();
	//HighestDegree from education
	private String highestDegree;
	
	@OneToMany(mappedBy="resumeData",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<EducationData> educationList=new ArrayList<>();

	private String jobPosition;

	@ElementCollection
	private List<String> topSkills = new ArrayList<>();

	private LocalDateTime createdDate;

}
