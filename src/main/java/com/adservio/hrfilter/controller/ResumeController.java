package com.adservio.hrfilter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adservio.hrfilter.data.model.ResumeData;
import com.adservio.hrfilter.dto.CVThequeDTO;
import com.adservio.hrfilter.dto.FindResumeDTO;
import com.adservio.hrfilter.dto.ResumeDTO;
import com.adservio.hrfilter.service.IResumeService;

@RestController
@RequestMapping("/resume")
public class ResumeController {
	
	@Autowired
	IResumeService resumeService;
	
	@PostMapping(value = "/addResume")
	public void addResume(@RequestBody CVThequeDTO cVThequeDTO) {
		resumeService.addResume(cVThequeDTO);
		
	}
	@PostMapping(value = "/findResumes")
	public List<ResumeDTO> findAllResumes(@RequestBody FindResumeDTO findResumeDTO) {
		return resumeService.findAllResumes(findResumeDTO);
	}

	@GetMapping(value="/findResume/{id}")
	public ResumeData findResumeById(@PathVariable(name = "id") Long id) {
		return resumeService.findResumeById(id);
	}
	
	@PutMapping(value="/editResume/{id}")
	public ResumeData setResumeById(@PathVariable(name = "id") Long id, @RequestBody ResumeData resumeData) {
		return resumeService.setResumeById(id,resumeData);
	}
}
