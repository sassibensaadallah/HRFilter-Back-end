package com.adservio.hrfilter.model;


import com.adservio.hrfilter.dto.CertificationDto;
import com.adservio.hrfilter.dto.LanguageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor @NoArgsConstructor
public class Resume {

//	private Long resumeId;
//	
	private String ProfessionalSummary;

	private Information ContactInformation;
	

	private Education Education;
	

	private Employment EmploymentHistory;
	
	private SkillData skills;

	private Skill skillsData;
	
	private List<CertificationDto> Certifications= new ArrayList<>();
	
	private List<LanguageDto> LanguageCompetencies= new ArrayList<>();

	
}
