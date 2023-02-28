package com.adservio.hrfilter.dto;

import com.adservio.hrfilter.data.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Data
public class ResumeDataDto {
    private Long resumeId;
    private PersonData personData ;
    private List<LanguageDto> languages;
    private List<Certification> certifications;
    private List<EmployerData> employerList=new ArrayList<>();
    private List<SkillDataModel> skills=new ArrayList<>();
    private String highestDegree;

    private List<EducationData> educationList=new ArrayList<>();
    private List<SkillDto> newSkills;
    private String professionalSummary;
    private String jobPosition;

    private List<String> topSkills;
}
