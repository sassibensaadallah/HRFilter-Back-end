package com.adservio.hrfilter.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.adservio.hrfilter.dto.FindResumeDTO;
import com.adservio.hrfilter.dto.ResumeDTO;
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
import com.adservio.hrfilter.utils.ResumeSpecificationUtils;

@Service
public class ResumeServiceImplementation implements IResumeService {
	private static final Logger LOG = LoggerFactory.getLogger(ResumeServiceImplementation.class);

	@Autowired
	ResumeRepository resumeRepository;

	@Override
	public ResumeData addResume(CVThequeDTO cvDTO) {
		ResumeData resumeData=new ResumeData();
		resumeData.setHighestDegree(getHighestDegreeFromDTO(cvDTO));
		resumeData.setProfessionalSummary(cvDTO.getValue().getResumeData().getProfessionalSummary());
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
		
			if(cvDTO.getValue().getResumeData().getEducation()!=null) {
				
				for(EducationDetail educationDetail: cvDTO.getValue().getResumeData().getEducation().getEducationDetails()) {
					try {
						EducationData educationData= new EducationData();
						if(educationDetail.getSchoolName()!=null)
							educationData.setSchoolName(educationDetail.getSchoolName().getNormalized());
						if(educationDetail.getDegree()!=null)
							educationData.setDegree(educationDetail.getDegree().getName().getNormalized());
						educationData.setDescrption(educationDetail.getText());
						if(educationDetail.getLastEducationDate()!=null)
							educationData.setLastDate(educationDetail.getLastEducationDate().getDate());
						educationDataList.add(educationData);
					LOG.info("educationData "+educationData.getDescrption());
					} catch (Exception e) {
						LOG.error("Error in setting education "+e);
					}
				}
			}
		
		return educationDataList;
	}

	private List<EmployerData> getEmplyerListFromDTO(CVThequeDTO cvDTO) {
		List<EmployerData> employerDataList=new ArrayList<>();
		
			if(cvDTO.getValue().getResumeData().getEmploymentHistory()!=null) {
				for(Position position: cvDTO.getValue().getResumeData().getEmploymentHistory().getPositions()) {
					try {
						EmployerData employer = new EmployerData();
						if(position.getEmployer()!=null&&position.getEmployer().getName()!=null)
							employer.setName(position.getEmployer().getName().getNormalized());
						if(position.getJobTitle()!=null)
							employer.setJobTitle(position.getJobTitle().getNormalized());
						if(position.getStartDate()!=null)
							employer.setStartDate(position.getStartDate().getDate());
						if(position.getEndDate()!=null)
							employer.setEndDate(position.getEndDate().getDate());
						employer.setDescription(position.getDescription());
						employerDataList.add(employer);
					}
					catch(Exception e) {
						LOG.error("Error in setting employment "+e);
					}
				}
			}
		return employerDataList;
	}

	private PersonData getPersonalDataFromDTO(CVThequeDTO cvDTO) {
		PersonData person=new PersonData();
		try {
			person.setFirstName(cvDTO.getValue().getResumeData().getContactInformation().getCandidateName().getGivenName());
			person.setLastName(cvDTO.getValue().getResumeData().getContactInformation().getCandidateName().getFamilyName());
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
						if(skill.getMonthsExperience()!=null)
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

	@Override
	public List<ResumeDTO> findAllResumes(FindResumeDTO findResumeDTO) {
		List<String> l=new ArrayList<>();
		l.add("JAVA");
		l.add("French");
		
		 /* filters a appliquer dans findAll
		 * ResumeSpecificationUtils.skillOfSkills(l).and(ResumeSpecificationUtils.experienceMoreThan(2)).and(ResumeSpecificationUtils.highestDegreeLike("")).and(ResumeSpecificationUtils.elementIsMemberOfListOfString(l))
		 */
		List<ResumeData> resumeDataList=resumeRepository.findAll(ResumeSpecificationUtils
				.skillOfSkills(findResumeDTO.getSkills())
				.and(ResumeSpecificationUtils.experienceMoreThan(findResumeDTO.getExperience()))
				.and(ResumeSpecificationUtils.highestDegreeLike(findResumeDTO.getHighestDegree()))
				.and(ResumeSpecificationUtils.elementIsMemberOfListOfString(findResumeDTO.getCertifications(),"certifications"))
				.and(ResumeSpecificationUtils.elementIsMemberOfListOfString(findResumeDTO.getLanguages(),"languages")));
		List<ResumeDTO> resumeDTOList=new ArrayList<>();
		for (ResumeData resumedata :resumeDataList) {
			ResumeDTO resumeDTO=new ResumeDTO();
			resumeDTO.setFirstName(resumedata.getPersonData().getFirstName());
			resumeDTO.setLastName(resumedata.getPersonData().getLastName());
			resumeDTO.setJobPosition(resumedata.getProfessionalSummary());
			resumeDTO.setCreatedBy("nom et prenom");
			resumeDTO.setResumeId(resumedata.getResumeId());
			resumeDTOList.add(resumeDTO);
		}
		return resumeDTOList;
	}

	@Override
	public ResumeData findResumeById(Long id) {
		Optional<ResumeData> resumeData=resumeRepository.findById(id);
		return resumeData.orElse(null);
	}

	@Override
	public ResumeData setResumeById(Long id, ResumeData resumeData) {
		resumeRepository.deleteById(id);
		return resumeRepository.save(resumeData);
	}
	
	
	
	
}
