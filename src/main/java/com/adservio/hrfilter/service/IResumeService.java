package com.adservio.hrfilter.service;

import com.adservio.hrfilter.data.model.ResumeData;
import com.adservio.hrfilter.dto.CVThequeDTO;

public interface IResumeService {
	ResumeData addResume(CVThequeDTO cv);
}
