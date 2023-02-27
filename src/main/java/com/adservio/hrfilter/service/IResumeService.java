package com.adservio.hrfilter.service;

import java.util.List;

import com.adservio.hrfilter.data.model.ResumeData;
import com.adservio.hrfilter.dto.CVThequeDTO;
import com.adservio.hrfilter.dto.FindResumeDTO;
import com.adservio.hrfilter.dto.ResumeDTO;
import com.adservio.hrfilter.dto.ResumeDataDto;

public interface IResumeService {
	ResumeDataDto addResume(CVThequeDTO cv);
	List<ResumeDTO> findAllResumes(FindResumeDTO findResumeDTO);
	ResumeDataDto findResumeById(Long id);
	ResumeData setResumeById(Long id, ResumeData resumeData);
}
