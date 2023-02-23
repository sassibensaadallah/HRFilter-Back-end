package com.adservio.hrfilter.controller;

import com.adservio.hrfilter.utils.ApiResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.adservio.hrfilter.data.model.ResumeData;
import com.adservio.hrfilter.dto.CVThequeDTO;
import com.adservio.hrfilter.dto.FindResumeDTO;
import com.adservio.hrfilter.service.IResumeService;

@RestController
@RequestMapping("/resume")
@CrossOrigin
public class ResumeController {
	
	@Autowired
	IResumeService resumeService;
	
	@PostMapping(value = "/addResume")
	public ResponseEntity<Object> addResume(@RequestBody CVThequeDTO cVThequeDTO) {
		try {
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"RESUME SUCCESSFULLY ADDED",
							resumeService.addResume(cVThequeDTO));
		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		
		}
	}
	@PostMapping(value = "/findResumes")
	public ResponseEntity<Object> findAllResumes(@RequestBody FindResumeDTO findResumeDTO) {
		try {
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"RESUME LIST SUCCESSFULLY GOT",
							resumeService.findAllResumes(findResumeDTO));
		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		}
	}

	@GetMapping(value="/findResume/{id}")
	public ResponseEntity<Object> findResumeById(@PathVariable(name = "id") Long id) {
		try {
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"RESUME WITH ID :"+id,
							resumeService.findResumeById(id));
		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		}
	}
	
	@PutMapping(value="/editResume/{id}")
	public  ResponseEntity<Object> setResumeById(@PathVariable(name = "id") Long id, @RequestBody ResumeData resumeData) {
		try {
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, true,
							"RESUME SUCCESSFULLY UPDATED",
							resumeService.setResumeById(id,resumeData));
		}catch (Exception e){
			return ApiResponseHandler
					.generateResponse(HttpStatus.OK, false,
							e.getMessage(),
							null);
		}
	}
}
