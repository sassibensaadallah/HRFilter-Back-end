package com.adservio.hrfilter.service;

import java.util.List;

import com.adservio.hrfilter.data.model.ResumeData;
import com.adservio.hrfilter.dto.CVThequeDTO;
import com.adservio.hrfilter.dto.FindResumeDTO;
import com.adservio.hrfilter.dto.ResumeDTO;

public interface IResumeService {
	ResumeData addResume(CVThequeDTO cv);
	List<ResumeDTO> findAllResumes(FindResumeDTO findResumeDTO);
	ResumeData findResumeById(Long id);
	ResumeData setResumeById(Long id, ResumeData resumeData);
}
