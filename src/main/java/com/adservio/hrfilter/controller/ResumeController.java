package com.adservio.hrfilter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adservio.hrfilter.dto.CVThequeDTO;
import com.adservio.hrfilter.service.IResumeService;

@RestController
public class ResumeController {
	
	@Autowired
	IResumeService resumeService;
	
	@PostMapping(value = "/addResume")
	public CVThequeDTO addResume(@RequestBody CVThequeDTO cVThequeDTO) {
		resumeService.addResume(cVThequeDTO);
		return cVThequeDTO;
	}
	
}
