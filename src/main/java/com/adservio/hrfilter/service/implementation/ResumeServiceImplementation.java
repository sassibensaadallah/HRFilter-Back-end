package com.adservio.hrfilter.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adservio.hrfilter.data.model.EducationData;
import com.adservio.hrfilter.data.model.EmployerData;
import com.adservio.hrfilter.data.model.PersonData;
import com.adservio.hrfilter.data.model.ResumeData;
import com.adservio.hrfilter.data.model.SkillDataModel;
import com.adservio.hrfilter.dto.CVThequeDTO;
import com.adservio.hrfilter.model.Certification;
import com.adservio.hrfilter.model.EducationDetail;
import com.adservio.hrfilter.model.Language;
import com.adservio.hrfilter.model.Position;
import com.adservio.hrfilter.model.Skill;
import com.adservio.hrfilter.model.SkillData;
import com.adservio.hrfilter.model.SubTaxonomy;
import com.adservio.hrfilter.model.Taxonomy;
import com.adservio.hrfilter.model.Telephone;
import com.adservio.hrfilter.repository.ResumeRepository;
import com.adservio.hrfilter.service.IResumeService;
@Service
public class ResumeServiceImplementation implements IResumeService {
	private static final Logger LOG = LoggerFactory.getLogger(ResumeServiceImplementation.class);

	@Autowired
	ResumeRepository resumeRepository;

	@Override
	public ResumeData addResume(CVThequeDTO cvDTO) {
		ResumeData resumeData=new ResumeData();
		resumeData.setHighestDegree(getHighestDegreeFromDTO(cvDTO));
		resumeData.setLanguages(getLanguagesFromDTO(cvDTO));
		resumeData.setCertifications(getCertificationsFromDTO(cvDTO));
		resumeData.setSkills(getSkillsFromDTO(cvDTO));
		resumeData.setPersonData(getPersonalDataFromDTO(cvDTO));
		resumeData.setEmployerList(getEmplyerListFromDTO(cvDTO));
		resumeData.setEducationList(getEducationListFromDTO(cvDTO));
		resumeRepository.save(resumeData);
		return resumeData;
	}

	private List<EducationData> getEducationListFromDTO(CVThequeDTO cvDTO) {
		List<EducationData> educationDataList=new ArrayList<>();
		try {
			for(EducationDetail educationDetail: cvDTO.getValue().getResumeData().getEducation().getEducationDetails()) {
				EducationData educationData= new EducationData();
				educationData.setSchoolName(educationDetail.getSchoolName().getNormalized());
				educationData.setDegree(educationDetail.getDegree().getName().getNormalized());
				educationData.setDescrption(educationDetail.getText());
				educationData.setLastDate(educationDetail.getLastEducationDate().getDate());
				educationDataList.add(educationData);
				LOG.info("educationData "+educationData.getDescrption());
			}
		} catch (Exception e) {
			LOG.error("Error in setting education "+e);
		}
		return educationDataList;
	}

	private List<EmployerData> getEmplyerListFromDTO(CVThequeDTO cvDTO) {
		List<EmployerData> employerDataList=new ArrayList<>();
		try {
			for(Position position: cvDTO.getValue().getResumeData().getEmploymentHistory().getPositions()) {
				EmployerData employer = new EmployerData();
				employer.setName(position.getEmployer().getName().getNormalized());
				employer.setJobTitle(position.getJobTitle().getNormalized());
				employer.setStartDate(position.getStartDate().getDate());
				employer.setEndDate(position.getEndDate().getDate());
				employerDataList.add(employer);
			}
		}
		catch(Exception e) {
			LOG.error("Error in setting employment "+e);
		}
		return employerDataList;
	}

	private PersonData getPersonalDataFromDTO(CVThequeDTO cvDTO) {
		PersonData person=new PersonData();
		try {
			person.setName(cvDTO.getValue().getResumeData().getContactInformation().getCandidateName().getFormattedName());
			person.setCountry(cvDTO.getValue().getResumeData().getContactInformation().getLocation().getCountryCode());
			person.setDescription(cvDTO.getValue().getResumeData().getEmploymentHistory().getExperienceSummary().getDescription());
			person.setExperience(cvDTO.getValue().getResumeData().getEmploymentHistory().getExperienceSummary().getMonthsOfWorkExperience());
			person.setAverageByEmployer(cvDTO.getValue().getResumeData().getEmploymentHistory().getExperienceSummary().getAverageMonthsPerEmployer());
			person.setPhoneNumbers(getPhoneNumbersFromDto(cvDTO.getValue().getResumeData().getContactInformation().getTelephones()));
			person.setMailAdresses(cvDTO.getValue().getResumeData().getContactInformation().getEmailAddresses());
		}catch(Exception e) {
			LOG.error("Error in setting personal data "+e);
		}
		return person;
	}

	

	private List<String> getPhoneNumbersFromDto(List<Telephone> telephones) {
		List<String> phones=new ArrayList<>();
		for(Telephone tel:telephones) {
			phones.add(tel.getNormalized());
		}
		return phones;
	}

	private List<SkillDataModel> getSkillsFromDTO(CVThequeDTO cvDTO) {
		List<SkillDataModel> skills=new ArrayList<>();
		try {
		for(SkillData skillData: cvDTO.getValue().getResumeData().getSkillsData()) {
			for(Taxonomy taxonomy :skillData.getTaxonomies()) {
				for(SubTaxonomy subtaxonomy :taxonomy.getSubTaxonomies()) {
					for(Skill skill : subtaxonomy.getSkills()) {
						SkillDataModel skillDataModel = new SkillDataModel();
						skillDataModel.setSkillName(skill.getName());
						skillDataModel.setExperienceInMonth(skill.getMonthsExperience().getValue());
						skills.add(skillDataModel);
					}
					
				}
			}
		}
		}catch(Exception e) {
			LOG.error("Error in setting Skills "+e);
		}
		return skills;
	}

	private List<String> getCertificationsFromDTO(CVThequeDTO cvDTO) {
		List<String> certifications=new ArrayList<>();
		try {
		for(Certification certification: cvDTO.getValue().getResumeData().getCertifications()) {
			certifications.add(certification.getName());
		}
		}catch (Exception e) {
			LOG.error("Error in setting certifications "+e);
		}
		return certifications;
	}

	private List<String> getLanguagesFromDTO(CVThequeDTO cvDTO) {
		List<String> languages=new ArrayList<>();
		try {
		for(Language language: cvDTO.getValue().getResumeData().getLanguageCompetencies()) {
			languages.add(language.getLanguage());
		}
		}catch(Exception e) {
			LOG.error("Error in setting languages "+e);
		}
		return languages;
	}

	private String getHighestDegreeFromDTO(CVThequeDTO cvDTO) {
		String name="";
		try {
			name=cvDTO.getValue().getResumeData().getEducation().getHighestDegree().getName().getNormalized();
		}catch(Exception e) {
			LOG.error("Error in setting degree "+e);
		}
		return name;
	}

}
