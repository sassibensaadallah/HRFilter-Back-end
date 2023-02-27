package com.adservio.hrfilter.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.adservio.hrfilter.data.model.*;
import com.adservio.hrfilter.dto.*;
import com.adservio.hrfilter.model.*;
import com.adservio.hrfilter.repository.CertificationRepository;
import com.adservio.hrfilter.repository.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adservio.hrfilter.repository.ResumeRepository;
import com.adservio.hrfilter.service.IResumeService;
import com.adservio.hrfilter.utils.ResumeSpecificationUtils;

@Service
public class ResumeServiceImplementation implements IResumeService {
	private static final Logger LOG = LoggerFactory.getLogger(ResumeServiceImplementation.class);

	@Autowired
	ResumeRepository resumeRepository;
	@Autowired
	private CertificationRepository certificationRepository;
	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public ResumeDataDto addResume(CVThequeDTO cvDTO) {
		ResumeData resumeData=new ResumeData();
		resumeData.setHighestDegree(getHighestDegreeFromDTO(cvDTO));
		resumeData.setProfessionalSummary(cvDTO.getValue().getResumeData().getProfessionalSummary());
		resumeData.setLanguages(cvDTO.getValue().getResumeData().getLanguageCompetencies()
									.stream().map(languageDto -> new Language(null, languageDto.getFoundInContext(), languageDto.getLanguage(), languageDto.getLanguageCode(), resumeData))
									.collect(Collectors.toList()));
		resumeData.setCertifications(cvDTO.getValue().getResumeData().getCertifications()
									.stream().map(certificationDto -> new Certification(null, certificationDto.isVariation(), certificationDto.getName(), certificationDto.isMatchedFromList(), resumeData))
									.collect(Collectors.toList()));
		resumeData.setSkills(getSkillsFromDTO(cvDTO, resumeData));
		resumeData.setPersonData(getPersonalDataFromDTO(cvDTO));
		resumeData.setEmployerList(getEmplyerListFromDTO(cvDTO));
		resumeData.setEducationList(getEducationListFromDTO(cvDTO));
		resumeRepository.save(resumeData);
		return toResumeDataDto(resumeData);
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

	private List<SkillDataModel> getSkillsFromDTO(CVThequeDTO cvDTO, ResumeData resumeData) {
		List<SkillDataModel> skills=new ArrayList<>();
		System.out.println("Skill = " + cvDTO.getValue().getResumeData().getSkills());
		try {
		for(SkillRow skillData: cvDTO.getValue().getResumeData().getSkills().getNormalized()) {
			SkillDataModel skillDataModel = new SkillDataModel();
			skillDataModel.setSkillName(skillData.getName());
			skillDataModel.setType(skillData.getType());
			skillDataModel.setResumeData(resumeData);
			System.out.println("Skill = " + skillData.getName());

			if(skillData.getMonthsExperience()!=null)
				skillDataModel.setExperienceInMonth(skillData.getMonthsExperience().getValue());
			skills.add(skillDataModel);
			/*for(Taxonomy taxonomy :skillData.getTaxonomies()) {
				for(SubTaxonomy subtaxonomy :taxonomy.getSubTaxonomies()) {
					for(Skill skill : subtaxonomy.getSkills()) {
						SkillDataModel skillDataModel = new SkillDataModel();
						skillDataModel.setSkillName(skill.getName());
						skillDataModel.setType(skill.getType());
						skillDataModel.setResumeData(resumeData);
						System.out.println("Skill = " + skill.getName());

						if(skill.getMonthsExperience()!=null)
							skillDataModel.setExperienceInMonth(skill.getMonthsExperience().getValue());
						skills.add(skillDataModel);
					}
					
				}
			}*/
		}
		}catch(Exception e) {
			LOG.error("Error in setting Skills "+e);
		}
		return skills;
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
				.and(ResumeSpecificationUtils.elementIsMemberOfListOfCertif(findResumeDTO.getCertifications(),"certifications"))
				.and(ResumeSpecificationUtils.elementIsMemberOfListOfLangage(findResumeDTO.getLanguages(),"languages")));
		List<ResumeDTO> resumeDTOList=new ArrayList<>();
		for (ResumeData resumedata :resumeDataList) {
			ResumeDTO resumeDTO=new ResumeDTO();
			resumeDTO.setFirstName(resumedata.getPersonData().getFirstName());
			resumeDTO.setLastName(resumedata.getPersonData().getLastName());
			resumeDTO.setJobPosition(resumedata.getProfessionalSummary());
			resumeDTO.setCreatedBy(null);
			resumeDTO.setResumeId(resumedata.getResumeId());
			resumeDTOList.add(resumeDTO);
		}
		return resumeDTOList;
	}

	@Override
	public ResumeDataDto findResumeById(Long id) {
		ResumeDataDto resumeDataDto = new ResumeDataDto();
		Optional<ResumeData> optResumeData=resumeRepository.findById(id);
		ResumeData resumeData = optResumeData.orElseThrow(() -> new RuntimeException("NOT FOUND"));
		resumeDataDto.setHighestDegree(resumeData.getHighestDegree());
		resumeDataDto.setProfessionalSummary(resumeData.getProfessionalSummary());
		resumeDataDto.setLanguages(resumeData.getLanguages());
		resumeDataDto.setCertifications(resumeData.getCertifications());
		resumeDataDto.setSkills(resumeData.getSkills());
		resumeDataDto.setPersonData(resumeData.getPersonData());
		resumeDataDto.setEmployerList(resumeData.getEmployerList());
		resumeDataDto.setEducationList(resumeData.getEducationList());
		resumeDataDto.setNewSkills(toNewSkill(resumeData.getSkills()));
		return resumeDataDto;
	}

	@Override
	public ResumeData setResumeById(Long id, ResumeData resumeData) {
		resumeData.setResumeId(id);
		return resumeRepository.save(resumeData);
	}


	public ResumeDataDto toResumeDataDto(ResumeData resumeData){
		ResumeDataDto resumeDataDto=new ResumeDataDto();
		resumeDataDto.setHighestDegree(resumeData.getHighestDegree());
		resumeDataDto.setProfessionalSummary(resumeData.getProfessionalSummary());
		resumeDataDto.setLanguages(resumeData.getLanguages());
		resumeDataDto.setCertifications(resumeData.getCertifications());
		resumeDataDto.setSkills(resumeData.getSkills());
		resumeDataDto.setPersonData(resumeData.getPersonData());
		resumeDataDto.setEmployerList(resumeData.getEmployerList());
		resumeDataDto.setEducationList(resumeData.getEducationList());
		resumeDataDto.setNewSkills(toNewSkill(resumeData.getSkills()));
		return resumeDataDto;
	}

	public List<SkillDto> toNewSkill(List<SkillDataModel> skills){
		List<SkillDto> skillDtos = new ArrayList<>();
		Map<String, List<String>> map =skills.stream()
				.collect(Collectors.groupingBy(SkillDataModel::getType, Collectors.mapping(SkillDataModel::getSkillName, Collectors.toList())));
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			SkillDto skillDto = new SkillDto(entry.getKey(), entry.getValue());
			skillDtos.add(skillDto);
		}
		return skillDtos;
	}



	
	
}
